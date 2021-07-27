package thaovan.java6.lab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication()
             .withUser("user1")
             .password("{noop}123456")
             .roles("USER")

             .and()
             .withUser("user2")
             .password(passwordEncoder.encode("123456"))
             .roles("ADMIN")

             .and()
             .withUser("user3")
             .password(passwordEncoder.encode("123456"))
             .roles("ADMIN", "USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // not use CorsFilter
                .cors().disable()

                // not use CsrfFilter
                .csrf().disable()
                .authorizeRequests()

                // path /auth/login without login
                // use to display login form
                .antMatchers("/auth/login**").permitAll()
                // path /home/index without login
                .antMatchers("/home/**").permitAll()

                .antMatchers("/admin**").hasRole("ADMIN")
                .antMatchers("/authenticated**", "/user**").hasAnyRole("ADMIN", "USER")

                // rest of path, login before
                .anyRequest().authenticated();

        http.exceptionHandling()
            .accessDeniedPage("/auth/access?denied");

        // using /logout of spring security

        http.formLogin()
            .loginPage("/auth/login")
            .defaultSuccessUrl("/home/index", false)
            .failureUrl("/auth/login?failure");

        http.rememberMe()
            .rememberMeParameter("remember");
     }
}
