package Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@ComponentScan("Services")
@EnableWebSecurity
public class SecurityConfig {
@Bean
public BCryptPasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder;
}
    public static class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private AccessDeniedHandler accessDeniedHandler;



        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")

                    .and()
                    .formLogin()
                    .loginPage("/staff-login")
                    .loginProcessingUrl("/admin_login")
                    .failureUrl("/loginAdmin?error=loginError")
                    .defaultSuccessUrl("/adminPage")

                    .and()
                    .logout()
                    .logoutUrl("/admin_logout")
                    .logoutSuccessUrl("/protectedLinks")
                    .deleteCookies("JSESSIONID")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")

                    .and()
                    .csrf().disable();
        }
    }

    @Configuration
    @Order(2)
    public static class SpringSecurityConfig2 extends WebSecurityConfigurerAdapter {


        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/user*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")

                    .and()
                    .formLogin()
                    .loginPage("/patient-login")
                    .loginProcessingUrl("/user_login")
                    .failureUrl("/loginUser?error=loginError")
                    .defaultSuccessUrl("/userPage")

                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/protectedLinks")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")

                    .and()
                    .csrf().disable();
        }
    }
}