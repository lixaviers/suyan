package com.suyan.user.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableResourceServer
public class SsoSecurityConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler userAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler userAuthenticationFailureHandler;

    @Autowired
    private LogoutSuccessHandler userLogoutSuccessHandle;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login/action")
                .loginProcessingUrl("/user/login")
                .successHandler(userAuthenticationSuccessHandler)
                .failureHandler(userAuthenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl("/userLogout")
                .logoutSuccessHandler(userLogoutSuccessHandle)
                .deleteCookies("JSESSIONID")
                .and()
                .authorizeRequests()
                .antMatchers("/login/action", "/user/login", "/login.html", "/reg.html", "/user/regist")
                .permitAll()
                .anyRequest()
                .authenticated()
//                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                .and().csrf().disable();
        ;
    }
}
