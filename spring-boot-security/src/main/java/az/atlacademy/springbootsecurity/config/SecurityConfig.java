package az.atlacademy.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig/* extends WebSecurityConfigurerAdapter*/ {

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
            authorizeRequests()
                .antMatchers("/employees/test").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception{
        String password="password";
        String encrytedPassword =  this.passwordEncoder().encode(password);
        auth.inMemoryAuthentication().withUser("admin").password(encrytedPassword).roles("USER");
    }
/*
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/employees/test");
    }
*/

}
