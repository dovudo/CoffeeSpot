package com.coffee.backend.Configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class Security: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests().
                antMatchers("/api/**").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().permitAll()

    }
}

//
//        http!!.authorizeRequests()
//                .antMatchers("/api/**").permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated().and()
//                .formLogin().loginPage("/login")
//                .successHandler(successHandler).and()
//                .logout().logoutUrl("/logout").and()
//                .httpBasic().and()
//                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .ignoringAntMatchers(
//                        "/instance",
//                        "/actuator/**")
//
