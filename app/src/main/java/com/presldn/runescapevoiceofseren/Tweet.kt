package com.presldn.runescapevoiceofseren


import com.google.gson.annotations.SerializedName

data class Tweet(@SerializedName("created_at")
                 val createdAt: String = "",
                 @SerializedName("text")
                 val text: String = ""
)
