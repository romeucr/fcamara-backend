package br.com.fcamara.config.audit;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.fcamara.repository.IUserRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = {"br.com.fcamara.repository"})
@EnableJpaAuditing
public class PersistenceConfig {
	
	@Bean
	AuditorAware<String> auditorAware(IUserRepository repo) {
		// Lookup Author instance corresponding to logged in user
		return () -> Optional.ofNullable(SecurityContextHolder.getContext())
				.map(SecurityContext::getAuthentication)
				.filter(Authentication::isAuthenticated)
				.map(Authentication::getName);
	}
}