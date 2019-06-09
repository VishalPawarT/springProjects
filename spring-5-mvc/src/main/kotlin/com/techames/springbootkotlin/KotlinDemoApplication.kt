package com.techames.springbootkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

@SpringBootApplication(scanBasePackages = arrayOf("com.techames.springbootkotlin"), exclude = arrayOf(SecurityAutoConfiguration::class))
class KotlinDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemoApplication::class.java, *args)
}
