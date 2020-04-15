package com.eheinen.kotlinreactive.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class HmacResolverSecurityConfig {

    @Bean
    fun authenticationContext(
        httpSecurity: ServerHttpSecurity
    ): SecurityWebFilterChain {
        return httpSecurity
            .httpBasic().disable()
            .authorizeExchange()
            .pathMatchers("/metrics", "/health", "/version", "/api/1/results").permitAll()
            .anyExchange().authenticated()
            .and()
            .csrf().disable()
            .build()
    }
}
