package thaovan.java6.lab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import thaovan.java6.lab.service.UserService;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // not use CorsFilter
                .cors().disable()

                // not use CsrfFilter
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/auth/login**","/home/**", "/js/**","/css/**", "/api/**").permitAll()

                .antMatchers("/admin**", "/authorities").hasRole("ADMIN")
                .antMatchers("/authenticated**", "/user**").hasAnyRole("USER", "GUEST")

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
