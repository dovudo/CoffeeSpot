package com.coffee.backend.Models

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
data class BadResponse(
        val ok: Boolean,
        val msg: String,
        @DateTimeFormat
        val date: Long
){
    constructor(massage:String) : this(false,massage, Date().time)
    constructor(massage:String, exception: Exception?) : this(false,massage, Date().time)

}