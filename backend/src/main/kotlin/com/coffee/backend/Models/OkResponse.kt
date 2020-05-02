package com.coffee.backend.Models

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.LocalDateTime

@ResponseStatus(HttpStatus.OK)
data class OkResponse(
        val ok:Boolean,
        val data:String,
        @JsonFormat(pattern="yyyy-MM-dd HH:mm")
        val timestamp: LocalDateTime = LocalDateTime.now()
)
{
    constructor(data: String) : this(true, data)
}
