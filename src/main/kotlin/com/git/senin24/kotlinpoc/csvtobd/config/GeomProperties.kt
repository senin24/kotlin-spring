package com.git.senin24.kotlinpoc.csvtobd.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.stereotype.Component

//@Component
@ConstructorBinding
@ConfigurationProperties(prefix = "geom20")
data class GeomProperties (
        val tfsPath: String,
        val firPath: String,
        val appInstance: Int,
        val expectedDivisionResult: Int
)