package com.coffee.backend.Models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class BadResponse(
        val ok: Boolean,
        val msg: String,
        @JsonFormat(pattern="yyyy-MM-dd HH:mm")
        val timestamp: LocalDateTime = LocalDateTime.now()
){
    constructor(massage:String) : this(false,massage)
    constructor(massage:String, exception: Exception?) : this(false,massage)

}