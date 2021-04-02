package uz.pdp.pcmarket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.pcmarket.util.Privileges;
import uz.pdp.pcmarket.util.Roles;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser(Roles.SUPER_ADMIN).password(passwordEncoder().encode("super-admin"))
                        .roles(Roles.SUPER_ADMIN).authorities(Privileges.RED_ALL_PRODUCT, Privileges.ADD_PRODUCT, Privileges.EDIT_PRODUCT, Privileges.DELETE_PRODUCT, Privileges.RED_ONE_PRODUCT)
                .and()
                .withUser(Roles.MODERATOR).password(passwordEncoder().encode("moderator"))
                        .roles(Roles.MODERATOR).authorities(Privileges.RED_ALL_PRODUCT, Privileges.ADD_PRODUCT, Privileges.EDIT_PRODUCT, Privileges.RED_ONE_PRODUCT)
                .and()
                .withUser(Roles.OPERATOR).password(passwordEncoder().encode("operator"))
                        .roles(Roles.OPERATOR).authorities(Privileges.RED_ALL_PRODUCT, Privileges.RED_ONE_PRODUCT);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/product").hasAuthority(Privileges.RED_ALL_PRODUCT)
                .antMatchers(HttpMethod.POST, "/api/product").hasAnyAuthority(Privileges.ADD_PRODUCT)
                .antMatchers(HttpMethod.PUT, "/api/product/*").hasAuthority(Privileges.EDIT_PRODUCT)
                .antMatchers(HttpMethod.DELETE, "/api/product/*").hasAuthority(Privileges.DELETE_PRODUCT)
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
