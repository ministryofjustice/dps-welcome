package uk.gov.justice.digital.hmpps.dps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@Order(1)
public class AuthenticationManagerConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        // @formatter:off
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // Can't have CSRF protection as requires session
                .and().csrf().disable()

                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().authenticated()


                .and()
                .exceptionHandling();
        // @formatter:on
    }

    @Override
    public void configure(final WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/webjars/**", "/favicon.ico",
                        "/health", "/info", "/ping");
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}
