package com.presldn.runescapevoiceofseren.model

import com.google.gson.annotations.SerializedName

data class TokenType(
    @SerializedName("token_type")
    var tokenType: String,

    @SerializedName("access_token")
    var accessToken: String
)