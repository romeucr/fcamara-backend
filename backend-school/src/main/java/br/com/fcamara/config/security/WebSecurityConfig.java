package br.com.fcamara.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fcamara.config.security.service.MyUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configuracaoGlobal(AuthenticationManagerBuilder auth, MyUserDetailsService myUserDetailsService) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(this.encoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] allowed = new String[] {
				 "/auth/register","/v2/api-docs", "/configuration/ui", 
		            "/swagger-resources/**", "/configuration/**", "/swagger-ui.html"
		            , "/webjars/**", "/csrf", "/"
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
	}

}
