package com.liutao.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import redis.clients.jedis.Jedis;

public class RedisUtil implements Serializable{
	
	 private static final long serialVersionUID = -1149678082569464779L;
	 InputStream in = RedisUtil.class.getClassLoader().getResourceAsStream("config/redis.properties");
	 Jedis jedis = null;
	 
	 public Jedis getInstence() throws IOException {
		 if(jedis == null) {
			 Properties p = new Properties();
			 p.load(in);
			 String host = p.getProperty("redis.addr");
			 Jedis jedis = new Jedis(host);
			 return jedis;
		 }else {
			 return this.jedis;
		 }
		 
	 }
}
