package com.example.springbootsecuringoauth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springbootsecuringoauth2.utils.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSecuringOauth2ApplicationTests {
	
	@Autowired
	RedisUtil redisUtil;
	@Value("${redis.cluster-open}")
	String open;

	@Test
	public void contextLoads() {
		
		//redisUtil.set("testKey", "yyyyMMdd");
		System.err.println("======="+open);
		
		String testValue = (String) redisUtil.get("testKey");
		
		System.err.println(testValue);
	}

}
