package Config;

import Services.AdminDetailsServiceImpl;
import Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
public class ApplicationSecurityConfig {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;

//    @Autowired
//    private AdminDetailsServiceImpl adminDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

//    @Bean
//    public AuthenticationProvider authProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
////        provider.setPasswordEncoder(passwordEncoder());
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return provider;
//    }


/*
//    This code here removes the restriction on permission for patient registration.
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/patient/registration")
//        .and()
//        .ignoring().antMatchers("/home")
//        .and()
//        .ignoring().antMatchers("/patient/login")
//        .and()
//                .ignoring().antMatchers("/staff/login");
//    }
*/

    @Configuration
    @Order(1)
    public static class AppSecurityAdminConfig extends WebSecurityConfigurerAdapter {

        public AppSecurityAdminConfig(){
            super();
        }

        @Autowired
        private AdminDetailsServiceImpl adminDetailsService;

        public AuthenticationProvider authProvider() {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(adminDetailsService);
//        provider.setPasswordEncoder(BCryptPasswordEncoder.);
            provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
            return provider;
        }

        //Todo Authentification works well, but authorization needs work. https://www.baeldung.com/role-and-privilege-for-spring-security-registration
        //Seems like a good starting point.
        //also
        //https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authenticationProvider(authProvider())
                    .antMatcher("/staff*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")

                    .and()
                    .formLogin()
                    .loginPage("/login-staff")
                    .loginProcessingUrl("/staff-login-process")
                    .defaultSuccessUrl("/staff/dashboard", true)
                    .failureUrl("/login-staff-error")

                    .and()
                    .logout().invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/logout-success").permitAll()

                    .and()
                    .csrf().disable();
        }
    }

@Configuration
@Order(2)
    public static class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    public AppSecurityConfig(){
        super();
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authenticationProvider(authProvider())
                    .antMatcher("/patient*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")

                    .and()
                    .formLogin()
                    .loginPage("/login-patient")
                    .loginProcessingUrl("/patient-login-process")
                    .defaultSuccessUrl("/patient/dashboard", true)
                    .failureUrl("/login-patient-error")

                    .and()
                    .logout().invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/logout-success").permitAll()

                    .and()
                    .csrf().disable();

/*
//                .and()
//                .authorizeRequests().antMatchers("/patient/login").permitAll()
//                .antMatchers("/patient/register").permitAll()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()

//                .and()
//                .formLogin()
//                .loginPage("/patient/login")
//                .loginProcessingUrl("/patient/login-process")
//                .defaultSuccessUrl("/patient/dashboard",true)
//                .failureUrl("/patient/login/error")

//                .and()
//                .logout().invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/logout-success").permitAll()
//
//                 .and()
//                .csrf().disable();
*///Here is the code for no User role check
        }
    }


}
