package com.coffee.backend.Routes

import com.coffee.backend.Models.BadResponse
import javassist.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {
    val log =LoggerFactory.getLogger("ExceptionHandler")
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFound(e:NotFoundException): BadResponse {
        log.info(e.message)
        return BadResponse(e.message!!, e)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun anyExceptions(e:java.lang.Exception){
        log.warn("We got some troubles, check it please ->",e)
        BadResponse("We got some problem :(", e)
    }
}