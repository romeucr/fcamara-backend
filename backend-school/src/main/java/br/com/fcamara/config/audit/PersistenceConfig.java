package br.com.fcamara.config.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = {"br.com.fcamara.repository"})
@EnableJpaAuditing
public class PersistenceConfig { }