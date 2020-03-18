package com.coffee.backend.Models

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
        @NotNull
        val date: String,
        @Column(name = "PAYMENT")
        @NotNull
        val payment: Double
)