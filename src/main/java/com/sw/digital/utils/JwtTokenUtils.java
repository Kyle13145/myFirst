package com.sw.digital.utils;

import java.util.Date;
import java.util.HashMap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwt工具类
 * @author Kyle
 *
 */

public class JwtTokenUtils {

	public static final String TOKEN_HEADER="Authorization";
	public static final String TOKEN_PREFIX="Bearer";
	
	private static final String SECRET = "jwtsecretdemo";
	private static final String ISS = "echisan";
	
	//过期时间为3600秒，一天
	private static final long EXPIRATION = 3600L;
	
	//选择了记住我之后的过期时间为7天
	private static final long EXPIREATION_REMEBER = 604800L;
	
	// 添加角色的key
    private static final String ROLE_CLAIMS = "rol";
	
	//创建token
	public static String createToken(String username,String role,boolean isRemeberMe) {
		long expiration = isRemeberMe ? EXPIREATION_REMEBER : EXPIRATION;
		HashMap<String, Object> map = new HashMap<>();
		map.put(ROLE_CLAIMS, role);
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS512, SECRET)
				// 这里要早set一点，放到后面会覆盖别的字段
				.setClaims(map)
				.setIssuer(ISS)
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
				.compact();
	}
	
	//从token中获取用户名
	public static String getUsername(String token) {
		return getTokenBody(token).getSubject();
	}
	
	// 获取用户角色
    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }
    
    
	//是否过期
	public static boolean isExpiration(String token) {
		return getTokenBody(token).getExpiration().before(new Date());
	}
	
	
	private static Claims getTokenBody(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	
	
	
}
