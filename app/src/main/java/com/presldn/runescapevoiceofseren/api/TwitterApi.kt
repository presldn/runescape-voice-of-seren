package com.presldn.runescapevoiceofseren.api

import com.presldn.runescapevoiceofseren.model.TokenType
import com.presldn.runescapevoiceofseren.model.Tweet
import io.reactivex.Observable
import retrofit2.http.*

interface TwitterApi {

    @FormUrlEncoded
    @POST("/oauth2/token")
    fun authenticate(@Header("Authorization") authorization: String,
                     @Field("grant_type") grantType: String): Observable<TokenType>

    @GET("/1.1/statuses/user_timeline.json?screen_name=jagexclock&count=1")
    fun getRecentTweet(@Header("Authorization") authorization: String): Observable<List<Tweet>>
}