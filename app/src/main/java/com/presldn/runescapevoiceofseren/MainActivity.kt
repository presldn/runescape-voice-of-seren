package com.presldn.runescapevoiceofseren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var subscription: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscription = RetrofitClient.getTwitterApi()
            .authenticate(BearerTokenClient.getBearerTokenCredentials(), "client_credentials")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tokenType ->
                getTweets(tokenType.accessToken)
            },
                {
                    Log.d(this.packageName, "response: $it")
                }
            )
    }

    private fun getTweets(accessToken: String) {
        subscription = RetrofitClient.getTwitterApi()
            .getRecentTweet("Bearer $accessToken")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({tweets ->
                Log.d(this.packageName, "response: $tweets")
                val activeClans = getActiveClans(tweets[0])

                Log.d(this.packageName, "Active clans are: ${activeClans.first} and ${activeClans.second}")
            },
                {
                    Log.d(this.packageName, "response: ${it.message}")
                }
            )
    }

    private fun getActiveClans(tweet: Tweet): Pair<String, String> {
        val text = tweet.text

        val activeClans: MutableList<String> = mutableListOf()

        clans.forEach { clan ->
            if (text.contains(clan)) {
                activeClans.add(clan)
            }

        }
        return Pair(activeClans[0], activeClans[1])
    }
}
