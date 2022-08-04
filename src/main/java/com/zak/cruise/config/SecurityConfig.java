package com.zak.cruise.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ObjectMapper objectMapper;
    private final RestAuthenticationSuccessHandler successHandler;
    private final RestAuthenticationFailureHandler failureHandler;
    private final String secret;

    public SecurityConfig(
            @Autowired UserDetailsService userDetailsService,
            PasswordEncoder bCryptPasswordEncoder,
            @Autowired ObjectMapper objectMapper,
            @Autowired RestAuthenticationSuccessHandler successHandler,
            RestAuthenticationFailureHandler failureHandler,
            @Value("${jwt.secret}") String secret) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = (BCryptPasswordEncoder) bCryptPasswordEncoder;
        this.objectMapper = objectMapper;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        this.secret = secret;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html","/v2/api-docs","/webjars/**","/swagger-resources/**").permitAll()
//                .antMatchers(HttpMethod.GET,"/board-games/**").permitAll()
//                .antMatchers(HttpMethod.POST,"/board-games/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_GAMEMASTER")
//                .antMatchers(HttpMethod.PUT,"/board-games/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_GAMEMASTER")
//                .antMatchers(HttpMethod.PATCH,"/board-games/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_GAMEMASTER")
//                .antMatchers(HttpMethod.DELETE,"/board-games/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_GAMEMASTER")
//                .anyRequest().authenticated()
                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/swagger-ui.html")
//                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilter(authenticationFilter())
                .addFilter(new JwtAuthorizationFilter(super.authenticationManager(), userDetailsService, secret))
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .headers().frameOptions().disable();
    }

    public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
        JsonObjectAuthenticationFilter authenticationFilter = new JsonObjectAuthenticationFilter(objectMapper);
        authenticationFilter.setAuthenticationSuccessHandler(successHandler);
        authenticationFilter.setAuthenticationFailureHandler(failureHandler);
        authenticationFilter.setAuthenticationManager(super.authenticationManager());
        return authenticationFilter;
    }
}