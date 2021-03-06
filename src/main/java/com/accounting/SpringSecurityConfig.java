package com.accounting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.accounting.stateless.security.StatelessAuthenticationFilter;
import com.accounting.stateless.security.TokenAuthenticationService;
import com.accounting.stateless.security.UserService;

@Configuration
@EnableWebSecurity
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserService userService;
	private final TokenAuthenticationService tokenAuthenticationService;

	public SpringSecurityConfig() {
		super(true);
		userService = new UserService();
		tokenAuthenticationService = new TokenAuthenticationService( userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling()
				.and()
				.anonymous()
				.and()
				.servletApi()
				.and()
				.headers()
				.cacheControl()
				.and()
				.authorizeRequests().antMatchers("/assets/**").permitAll()

				// Allow anonymous resource requests
				// .antMatchers("/").permitAll()
				.antMatchers("/favicon.ico")
				.permitAll()
				.antMatchers("/**/*.html")
				.permitAll()
				.antMatchers("/**/*.css")
				.permitAll()
				.antMatchers("/**/*.js")
				.permitAll()

				// Allow anonymous logins
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/**").permitAll()
					.antMatchers(HttpMethod.GET,"/api/image/**").permitAll()
				.antMatchers("/configuration/**").permitAll()
				.antMatchers("/api/create/**").permitAll()
					.antMatchers("/public/reset").permitAll()
				.antMatchers(HttpMethod.POST,"/api/users/").permitAll()
				.antMatchers("/v2/**").permitAll()
				.antMatchers("/api/signup/**/**").permitAll()
				.antMatchers("/save/**").permitAll()
				.antMatchers("/find/**").permitAll()
				// All other request need to be authenticated
				.anyRequest().authenticated().and()

				// Custom Token based authentication based on the header
				// previously given to the client
				.addFilterBefore(
						new StatelessAuthenticationFilter(
								tokenAuthenticationService),
						UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(
				new BCryptPasswordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	@Override
	public UserService userDetailsService() {
		return userService;
	}

	@Bean
	public TokenAuthenticationService tokenAuthenticationService() {
		return tokenAuthenticationService;
	}
}
