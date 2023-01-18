//package com.b4.apollo.common.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//@Configuration
//public class SpringSecurityConfiguration {
//
//
//
//    @Bean
//    public BCryptPasswordEncoder encode() {
//
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer configure() {
//
//        return (web) -> web.ignoring().mvcMatchers(
//                "/css/**", "/js/**", "/images/**"
//        );
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
//
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .antMatchers("/","/main","/user/login","user/signup", "/**").permitAll()
//                .antMatchers("/user/mypage").authenticated()
////                .antMatchers("/user/**").authenticated()
////                .antMatchers("/user/mypage").hasRole("USER")
////                .antMatchers("/").hasRole("ADMIN")
////                .antMatchers("/user/mypage","/user/update", "/user/delete").hasAnyRole("ADMIN","USER")
////                .antMatchers(memberPermitList.toArray(new String[memberPermitList.size()])).hasAnyRole("MEMBER", "ADMIN")
////                .antMatchers(adminPermitList.toArray(new String[adminPermitList.size()])).hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/user/login")
//                .loginProcessingUrl("/user/login")
//                .successForwardUrl("/user/mypage")
//                .failureForwardUrl("/user/login")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true)
//                .logoutSuccessUrl("/")
//                .and()
//                .exceptionHandling();
//
//        return http.build();
//    }
//
//}
