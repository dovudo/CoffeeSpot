package com.coffee.backend.Models

import com.sun.istack.Nullable
import org.springframework.format.annotation.DateTimeFormat
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

@Entity
@Table
data class Transaction(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Int,

        @OneToMany
        @JoinColumn(name= "ITEMS_ID")
        val items: List<Items>?,

        @Column(name = "DATE")
        @NotNull
        @DateTimeFormat(pattern = "HH:mm yyyy-MM-dd")
        val date: String,

        @Column(name = "COUNT")
        @Nullable
        @Max(1024)
        val count: String?,

        @Column(name = "PAYMENT")
        @NotNull
        val payment: Int
)