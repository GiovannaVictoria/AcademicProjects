package br.ufscar.dc.dsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.ufscar.dc.dsw.security.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UsuarioDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authz) -> authz.requestMatchers("/error", "/index/**", "/js/**").permitAll()
				.requestMatchers("/pacientes").permitAll()
	            .requestMatchers("/medicos").permitAll()
	            .requestMatchers("/consultas").permitAll()
	            .requestMatchers("/pacientes/{id}").permitAll()
	            .requestMatchers("/medicos/{id}").permitAll()
	            .requestMatchers("/consultas/{id}").permitAll()
	            .requestMatchers("/medicos/especialidades/{nome}").permitAll()
	            .requestMatchers("/consultas/pacientes/{id}").permitAll()
	            .requestMatchers("/consultas/medicos/{id}").permitAll()
//	            // Demais URLs precisam de autenticação
//	            .anyRequest().authenticated()
				.requestMatchers("/css/**", "/image/**", "/webjars/**").permitAll()
//				.requestMatchers("/consultas/**").hasRole("USER")
//				.requestMatchers("/medicos/**", "/pacientes/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin((form) -> form.loginPage("/index").defaultSuccessUrl("/home", true).permitAll())
				.logout((logout) -> logout.logoutSuccessUrl("/").permitAll());

		return http.build();
	}

}