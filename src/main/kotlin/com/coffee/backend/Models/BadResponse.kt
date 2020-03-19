package com.coffee.backend.Models

import org.springframework.format.annotation.DateTimeFormat
import java.util.*

data class BadResponse(
        val ok: Boolean,
        val msg: String,
        @DateTimeFormat
        val date: Long
){
    constructor(massage:String) : this(false,massage, Date().time)
    constructor(massage:String, exception: Exception?) : this(false,massage, Date().time)

}