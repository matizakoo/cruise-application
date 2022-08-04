//package com.zak.cruise.config;
//
////import com.zak.cruise.service.impl.UserDetailServiceImpl;
//import com.zak.cruise.service.impl.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Qualifier("myUserDetailsService")
//    @Autowired
//    UserDetailsService userDetailsService;
////    @Autowired
////    MyUserDetailsService myUserDetailsService;
//    @Autowired
//    public BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//
//        auth.inMemoryAuthentication().
//                withUser("user").password(passwordEncoder.encode("password")).roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("ADMIN");
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("ADMIN","USER")
//                .antMatchers("/").permitAll()
//                .and().formLogin();
//    }
//
////    private final DelegatingPasswordEncoder delegatingPasswordEncoder;
////    public SecurityConfiguration(DelegatingPasswordEncoder delegatingPasswordEncoder){
////        this.delegatingPasswordEncoder = delegatingPasswordEncoder;
////    }
//}
