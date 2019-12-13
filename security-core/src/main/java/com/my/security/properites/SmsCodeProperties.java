package com.my.security.properites;

import lombok.Data;

@Data
public class SmsCodeProperties {

	private int length = 6;
	private int exprireTime = 60;
	private String url;

}