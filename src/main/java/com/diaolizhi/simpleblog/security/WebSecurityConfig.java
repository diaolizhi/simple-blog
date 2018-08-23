package com.diaolizhi.simpleblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/10 14:21
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/edit/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/error2")
                .and()
                .logout().logoutSuccessUrl("/");

        http.headers().defaultsDisabled().cacheControl();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        String password = encoder.encode("mp5201314");
        auth
                .inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("admin").password(password).roles("ADMIN");
    }

}
