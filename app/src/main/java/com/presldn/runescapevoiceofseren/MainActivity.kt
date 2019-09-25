package com.presldn.runescapevoiceofseren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

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
            .getTweets("Bearer $accessToken")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(this.packageName, "response: $it")
            },
                {
                    Log.d(this.packageName, "response: ${it.message}")
                }
            )
    }
}
