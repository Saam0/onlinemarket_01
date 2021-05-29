package am.onlinemarket.Configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(superPAss())
                .usersByUsernameQuery(
                        "Select login,password,status FROM user_tab WHERE email = ?")
                .authoritiesByUsernameQuery(
                        "Select login,role from user_tab where email=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

//                .antMatchers("/reg","/block").anonymous()
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/new").anonymous()
                .antMatchers("/index").anonymous()
//                .antMatchers("/add-user","/reset/**").permitAll()

//                .antMatchers("/login/**").anonymous()

//                .antMatchers("/admin/**").hasAnyRole("admin")

                .anyRequest().authenticated()

                .and()

                .formLogin()
                .loginPage("/").permitAll()
                .and()
                .logout().permitAll().logoutSuccessUrl("/");


    }




    @Bean
    public PasswordEncoder superPAss() {
        return new BCryptPasswordEncoder();
    }

}
