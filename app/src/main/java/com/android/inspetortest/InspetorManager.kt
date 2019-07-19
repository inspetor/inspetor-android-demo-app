package com.android.inspetortest


import android.content.Context
import com.inspetor.*

object InspetorManager {
    var config = InspetorConfig("inspetor.android", "1234", true)
    var inspetor: InspetorClient = InspetorClient()

    fun setup(context: Context) {
        inspetor.setup(config)
        inspetor.collect(context)
    }
}