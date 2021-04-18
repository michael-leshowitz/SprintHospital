package Config;

import Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebSecurity
@ComponentScan("Services")
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(passwordEncoder());
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

//    This code here removes the restriction on permission for patient registration.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/patient/registration")
        .and()
        .ignoring().antMatchers("/home")
        .and()
        .ignoring().antMatchers("/patient/login")
        .and()
                .ignoring().antMatchers("/staff/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .antMatcher("/patient*")
//                .authorizeRequests()
//                .anyRequest()
//                .hasRole("USER")
//
//                .and()
                .authorizeRequests().antMatchers("/patient/login").permitAll()
                .antMatchers("/patient/register").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/patient/login")
                .loginProcessingUrl("/patient/login-process")
                .defaultSuccessUrl("/patient/dashboard",true)
//                .permitAll()
                .failureUrl("/patient/login/error")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout-success").permitAll()

                 .and()
                .csrf().disable();

    }

//Todo Move these elsewhere. Make another config


}
