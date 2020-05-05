package com.git.senin24.kotlinpoc.csvtobd.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
//@EnableAsync
@EnableConfigurationProperties(GeomProperties::class)
//@ConfigurationPropertiesScan( "com.git.senin24.kotlinpoc.csvtobd" )
@EnableScheduling
class AppConfig {
}