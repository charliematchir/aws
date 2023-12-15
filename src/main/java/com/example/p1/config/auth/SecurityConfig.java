package com.example.p1.config.auth;

import com.example.p1.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests( auth -> auth
                                .requestMatchers(
                                        new AntPathRequestMatcher("/"),
                                        new AntPathRequestMatcher("/css/**"),
                                        new AntPathRequestMatcher("/images/**"),
                                        new AntPathRequestMatcher("/js/**"),
                                        new AntPathRequestMatcher("/h2-console/**"),
                                        new AntPathRequestMatcher("/profile/**")
                                ).permitAll()
                                .requestMatchers( new AntPathRequestMatcher("/api/v1/**")).hasRole(Role.USER.name())
                                .anyRequest().authenticated())
            .logout( (logout) -> logout.logoutSuccessUrl("/"))
            .oauth2Login( (oauth2) -> oauth2.userInfoEndpoint(
                (userinfoEndpoint) -> userinfoEndpoint
                        .userService(customOAuth2UserService))
                .defaultSuccessUrl("/", true));
        return http.build();
    }
}
