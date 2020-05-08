package com.coffee.backend.Models

import com.sun.istack.Nullable
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

@Entity
@Table
data class Items(
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Id
        @Column(name = "ID")
        val id: Int,

        @Column(name = "NAME", unique = true)
        @NotNull(message = "Name should't be empty")
        @Max(value = 15, message = "Too long name, please short it")
        val name: String,

        @Column(name = "DESCRIPTION")
        @NotNull
        @Max(64, message = "Too long description, please short it")
        val description: String,

        @Column(name = "TYPE")
        @NotNull
        val type:ItemType,

        @Column(name = "PRICE")
        @NotNull(message = "Price is empty, please enter the price")
        val price: Int,

        @NotNull
        @Column(name = "PICS")
        val pic:String
)
