package com.my.security.authorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认证服务器配置
 * @author Administrator
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthenticationServerConfig {
//	extends AuthorizationServerConfigurerAdapter {

//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		// 设置服务认证的加密方式
//		//加了下面两句话，客户端才能通过jwt 获取 token_key
//		security.allowFormAuthenticationForClients();
//		security.tokenKeyAccess("isAuthenticated()");
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		  clients.inMemory() // 使用in-memory存储
//          .withClient("myDemoClient") // client_id
//          .secret("myDemoSecret") // client_secret
//          .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
//          .redirectUris("http://example.com")
//          .scopes("all"); // 允许的授权范围
//	}
	
	
	

}
