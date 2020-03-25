package com.coffee.backend.Models

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table
data class Transaction(
        @Id
        @GeneratedValue
        val id: Int,

        @OneToMany
        @JoinColumn(name= "ITEMS_ID")
        val items: Set<Items>,

        @Column(name = "DATE")
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        val date: LocalDateTime = LocalDateTime.now(),

        @Column(name = "PAYMENT")
        @NotNull
        val payment: Int
)