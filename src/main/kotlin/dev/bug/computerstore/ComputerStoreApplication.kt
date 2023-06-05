package dev.bug.computerstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ComputerStoreApplication

fun main(args: Array<String>) {
    runApplication<ComputerStoreApplication>(*args)
}
