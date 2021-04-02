package br.com.fcamara.config.security;

import br.com.fcamara.config.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	// Para verificar o profile de execução e permitir o load correto do H2.
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
=======
	@Autowired
	public void configuracaoGlobal(AuthenticationManagerBuilder auth, MyUserDetailsService myUserDetailsService)
			throws Exception {
>>>>>>> 7e403eff19da498cd27425d181e33ec82408ab52
		auth.userDetailsService(myUserDetailsService).passwordEncoder(this.encoder());
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] allowed = new String[] { "/auth/register-donor", "/v2/api-docs", "/configuration/ui",
				"/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**", "/csrf", "/",
				"/h2-console/**", "/actuator/**" };

		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers(allowed).permitAll().anyRequest().authenticated().and().httpBasic();

	}*/

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;

	}
}
