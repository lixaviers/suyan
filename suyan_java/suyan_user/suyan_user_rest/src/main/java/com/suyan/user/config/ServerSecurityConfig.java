package com.suyan.user.config;//package com.suyan.user.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
//@Configuration
//public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http;
//
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//    }
//}
