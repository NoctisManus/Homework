package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration // 스프링 설정 클래스 지정, 등록된 Bean 생성 시점
@EnableWebSecurity // 스프링 보안 활성화
public class SecurityConfig { // 스프링에서 보안 관리 클래스
@Bean // 명시적 의존성 주입 : Autowired와 다름
// 5.7버전 이전 WebSecurityConfigurerAdapter 사용
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests(auth -> auth
.requestMatchers("/join_new", "/api/members", "/member_login", "/api/login_check", "/logout", "/", "/board_list", "/board_view/**", "/board_edit/**", "/board_write", "/api/boards", "/api/board_edit/**", "/api/board_delete/**", "/css/**", "/js/**", "/img/**", "/lib/**").permitAll() // 인증 없이 접근 가능
.anyRequest().authenticated() // 나머지는 인증 필요
)
.logout(logout -> logout.disable()) // Spring Security 기본 로그아웃 비활성화
.csrf(csrf -> csrf.disable()); // CSRF 비활성화 (개발 환경)
return http.build(); // 필터 체인을 통해 보안설정(HttpSecurity)을 반환
}
@Bean // 암호화 설정
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder(); // 비밀번호 암호화 저장
}
}

