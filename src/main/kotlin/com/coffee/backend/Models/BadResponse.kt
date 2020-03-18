package com.coffee.backend.Models

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
data class BadResponse(
        val ok: Boolean,
        val msg: String,
        val exception: Exception?,
        val date: Long
){
    constructor(massage:String) : this(false,massage,null, Date().time)
    constructor(massage:String, exception: Exception?) : this(false,massage,exception, Date().time)

}