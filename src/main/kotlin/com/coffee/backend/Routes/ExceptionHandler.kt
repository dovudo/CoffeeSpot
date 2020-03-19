package com.coffee.backend.Routes

import com.coffee.backend.Models.BadResponse
import javassist.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {

    val log =LoggerFactory.getLogger("ExceptionHandler")

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun notFound(e:NotFoundException): BadResponse {
        log.info(e.message)
        return BadResponse(e.message!!)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    fun anyExceptions(e:java.lang.Exception): BadResponse {
        log.warn("We got some troubles, check it please ->",e)
        return BadResponse("We got some problem :(")
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun illegalArgument(e: IllegalArgumentException): BadResponse {
        return BadResponse(e.message.toString())
    }

    //TODO IllegalStateException
}