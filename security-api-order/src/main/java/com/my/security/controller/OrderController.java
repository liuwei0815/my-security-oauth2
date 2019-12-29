package com.my.security.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.my.security.securityconfig.MyUser;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
	
	//private RestTemplate restTemplate = new RestTemplate();
	
	private static final String RPURL = "http://localhost:7023/";
	
	/**
	 * 如果不做转换用户信息处理 那么只能获取 username ，如果做了转换 那么这个就不能这么获取了
	 * @param order
	 * @param error
	 * @param username
	 * @return
	 */
	@PostMapping
	public Order getOrder(@Valid @RequestBody Order order,BindingResult error,@AuthenticationPrincipal String username) {
		if(error.hasErrors()) {
			error.getAllErrors().stream().map(e->buildError(e)).findFirst();
		}
		log.info("oauth2 获取用户信息:{}",username);
		
		//PriceInfo pi = restTemplate.getForObject(RPURL+"price/"+order.getProductId(), PriceInfo.class);
		//log.info("获取产品id：{},价格：{}",order.getProductId(),pi.getPrice());
		return  order;
	}

	@GetMapping("/getUserInfo1/{productId}")
	public Order getUser1(@PathVariable String productId,@AuthenticationPrincipal MyUser user) {
		log.info("MyUser：{}",user.getId());
		return  new Order();
	}
	
	@GetMapping("/getUserInfo2/{productId}")
	public Order getUser2(@PathVariable String productId,@AuthenticationPrincipal(expression = "#this.id") Long userId) {
		log.info("spring 表单时只获取其中一个属性：{}",userId);
		return  new Order();
	}
	
	@GetMapping("/{productId}")
	public Order getUser(@PathVariable String productId) {
		log.info("productId：{}",productId);
		return  new Order();
	}
	
	private Object buildError(ObjectError e) {
		throw new RuntimeException(e.getDefaultMessage());
	}
}
