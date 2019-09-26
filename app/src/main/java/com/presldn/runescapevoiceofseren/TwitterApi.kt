package com.presldn.runescapevoiceofseren

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface TwitterApi {

    @FormUrlEncoded
    @POST("/oauth2/token")
    fun authenticate(@Header("Authorization") authorization: String,
                     @Field("grant_type") grantType: String): Observable<TokenType>

    @GET("/1.1/statuses/user_timeline.json?screen_name=jagexclock&count=1")
    fun getRecentTweet(@Header("Authorization") authorization: String): Observable<List<Tweet>>
}