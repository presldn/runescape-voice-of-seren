package com.presldn.runescapevoiceofseren

import android.util.Base64

object BearerTokenClient {
    fun getBearerTokenCredentials(): String {
        return "Basic ${Base64.encodeToString(("$API_KEY:$API_SECRET_KEY").toByteArray(), Base64.NO_WRAP)}"
    }
}