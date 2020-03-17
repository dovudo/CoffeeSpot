package com.coffee.backend.Models

import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull


data class Transaction(
        @Id
        @GeneratedValue
        val id: Int,
        @Column(name = "ITEMS")
        @NotNull
        val items:List<Int>,
        @Column(name = "DATE")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        val date: Date,
        @Column(name = "payment")
        @NotNull
        val payment: Double
)