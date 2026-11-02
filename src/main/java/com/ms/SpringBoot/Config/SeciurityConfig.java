package com.ms.SpringBoot.Config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SeciurityConfig {
    @Bean
    UserDetailsService users(DataSource dataSource,
            @Value("${spring.queries.users-query}") String usersQuery,
            @Value("${spring.queries.roles-query}") String rolesQuery) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery(usersQuery);
        users.setAuthoritiesByUsernameQuery(rolesQuery);
        return users;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/register", "/adduser", "/resources/**", "/webjars/**").permitAll()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/").usernameParameter("login").passwordParameter("password"))
            .logout(logout -> logout.logoutSuccessUrl("/"))
            .exceptionHandling(errors -> errors.accessDeniedPage("/denied"))
            .build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
