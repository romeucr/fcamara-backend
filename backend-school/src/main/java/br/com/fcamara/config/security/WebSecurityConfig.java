package br.com.fcamara.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fcamara.config.security.service.MyUserDetailsService;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private MyUserDetailsService myUserDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(encoder());
		super.configure(auth);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		String[] allowed = new String[] {
						"/v2/api-docs"          , "/configuration/ui",
						"/swagger-resources/**" , "/configuration/**" , "/swagger-ui.html" ,
						"/webjars/**"           , "/h2-console/**"    , "/actuator/**"
		};

		web.ignoring().antMatchers(allowed);
	}

/*	@Autowired
	public void configuracaoGlobal(AuthenticationManagerBuilder auth, MyUserDetailsService myUserDetailsService) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(this.encoder());
		super.configure(auth);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] allowed = new String[] {
				 "/auth/register","/v2/api-docs", "/configuration/ui", 
		            "/swagger-resources/**", "/configuration/**", "/swagger-ui.html"
		            , "/webjars/**", "/csrf", "/", "/h2-console/**", "/actuator/**"
			};

		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(allowed).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

	}*/

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
