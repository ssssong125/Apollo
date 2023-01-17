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
////        Map<String, List<String>> permitListMap = authenticationService.getPermitListMap();//getPermitListMap 만들어서 권한별로 접근가능한 url 목록을 받아오자 AuthenticationService, 와 Impl 에 가서 추가구현하자
////        List<String> adminPermitList = permitListMap.get("adminPermitList");
////        List<String> memberPermitList = permitListMap.get("memberPermitList");
////
////        adminPermitList.forEach(url -> System.out.println("admin permit list : " + url));
////        memberPermitList.forEach(url -> System.out.println("member permit list : " + url));
//
//        http.csrf().disable()  // token 위조방지 비활성화
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
//                .formLogin()    //form 을 이용해서 로그인
//                .loginPage("/user/login")  //
//                .loginProcessingUrl("/user/login")
//                .successForwardUrl("/user/mypage")  //로그인 성공시 이동할 경로 설정
//                .failureForwardUrl("/user/login") //에러가 발생했을 때 forwarding 할 경로 기술
//                .and()
//                .logout() //로그아웃설정
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                .deleteCookies("JSESSIONID") //성공적으로 수행되었을 때 쿠키를 제거할 키 값을 넣어서 설정
//                .invalidateHttpSession(true) //로그아웃 처리할 때 세션 만료시킴
//                .logoutSuccessUrl("/")
//                .and()
//                .exceptionHandling();
////                .accessDeniedPage("/error/denied");
//
//        return http.build();
//    }
//
//}
