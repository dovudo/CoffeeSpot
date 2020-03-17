package com.coffee.backend.Models

import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.Length
import org.springframework.beans.factory.annotation.Value
import java.io.File
import java.nio.file.Path
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

@Entity
data class Items(
        @GeneratedValue
        @Id
        @Column(name = "ID")
        val id: Int,
        @Column(name = "NAME", unique = true)
        @NotNull(message = "Name should't be empty")
        @Max(value = 15, message = "Too long name, please short it")
        val name: String,
        @Column(name = "DESCRIPTION")
        @Max(64, message = "Too long description, please short it")
        val description: String?,
        @Column(name = "PRICE")
        @NotNull(message = "Price is empty, please enter the price")
        val price: Double,
        @NotNull
        @Column(name = "PICS")
        val pics:File
) {
        constructor() : this(-1, "SomeCoffee","Some description", 16.20, File("F")) {

        }
}
