/**  
* @Title: WebSecurityConfig.java
* @Package com.osxm.websecurity.config
* @Description: TODO
* @author XM
* @date 2023年2月8日 下午10:05:28
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	/**
	 * 创建内存用户： oscar/123456
	 * 
	 * @return
	 */
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
		users.createUser(User.withUsername("oscar")
				.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456")).roles("admin").build());
		return users;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests().//访问权限控制
				antMatchers("/client/**").anonymous() //允许匿名访问
               .antMatchers("/api/**").authenticated().and().httpBasic() //需要Basic 认证
               .and().build();
	}

}
