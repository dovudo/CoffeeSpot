package com.coffee.backend.Models

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@ResponseStatus(HttpStatus.OK)
data class OkResponse(
        val ok:Boolean,
        val data:String,
        @DateTimeFormat
        val timestamp: Long
)
{
    constructor(data:String) : this(true, data, Date().time)
}
