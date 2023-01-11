//package com.b4.apollo.common.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@EnableWebSecurity
//public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
////    private final UserService authenticationService;
//    //@Autowired
////    public SpringSecurityConfiguration(UserService authenticationService){
////        this.authenticationService = authenticationService;
////    }
//    //extends Web어쩌구 하고 override 했던게 빈 등록으로 바뀜
//    @Bean
//    public PasswordEncoder passwordEncoder() {
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
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/**").permitAll()
////                .antMatchers("/product/**").authenticated()
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/cart/**").hasAnyRole("ADMIN","MEMBER")
////                .antMatchers(memberPermitList.toArray(new String[memberPermitList.size()])).hasAnyRole("MEMBER", "ADMIN")
////                .antMatchers(adminPermitList.toArray(new String[adminPermitList.size()])).hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()    //form 을 이용해서 로그인
//                .loginPage("/user/login")  //
//                .successForwardUrl("/user/mypage")  //로그인 성공시 이동할 경로 설정
//                .failureForwardUrl("/error") //에러가 발생했을 때 forwarding 할 경로 기술
//                .and()
//                .logout() //로그아웃설정
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                .deleteCookies("JSESSIONID") //성공적으로 수행되었을 때 쿠키를 제거할 키 값을 넣어서 설정
//                .invalidateHttpSession(true) //로그아웃 처리할 때 세션 만료시킴
//                .logoutSuccessUrl("/main")
//                .and()
//                .exceptionHandling();
//        return http.build();
//    }
//
//}
