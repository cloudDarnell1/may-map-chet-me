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
             .password("123456")
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
        http.cors().disable().csrf().disable()
                .authorizeRequests().antMatchers("/home/index")
                .authenticated();

        http.httpBasic()
            .and()
            .logout()
            .logoutSuccessUrl("/home/index")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID");
     }
}
