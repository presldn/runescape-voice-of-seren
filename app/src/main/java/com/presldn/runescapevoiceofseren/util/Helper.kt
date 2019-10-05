package com.presldn.runescapevoiceofseren.util

object Helper {
    fun concatInfo(info: Array<String>): String {
        val builder = StringBuilder()

        info.forEach {
            builder.append("$it \n\n")
        }

        return builder.toString()
    }
}