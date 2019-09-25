package com.presldn.runescapevoiceofseren

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface TwitterApi {

    @FormUrlEncoded
    @POST("/oauth2/token")
    fun authenticate(@Header("Authorization") authorization: String,
                     @Field("grant_type") grantType: String): Observable<TokenType>

    @FormUrlEncoded
    @GET("/1.1/search/tweets.json?q=from")
    fun getTweets(@Header("Authorization") authorization: String)
}