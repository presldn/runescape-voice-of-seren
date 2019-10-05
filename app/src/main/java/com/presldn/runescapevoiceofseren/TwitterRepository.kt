package com.presldn.runescapevoiceofseren

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TwitterRepository {

    private lateinit var subscription: Disposable

    private fun authenticate() {
        subscription = RetrofitClient.getTwitterApi()
            .authenticate(BearerTokenClient.getBearerTokenCredentials(), "client_credentials")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tokenType ->
                getRecentTweet(tokenType.accessToken)
            },
                {
                }
            )
    }

    private fun getRecentTweet(accessToken: String) {
        subscription = RetrofitClient.getTwitterApi()
            .getRecentTweet("Bearer $accessToken")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tweets ->
                val activeClans = getActiveClans(tweets[0])

            },
                {
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