package com.sw.digital.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtAdmin implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtAdmin() {

	}

	// 写一个能够直接使用User创建jwtUser的构造器
	public JwtAdmin(Admin admin) {
		id = admin.getId();
		username = admin.getName();
		password = admin.getPassword();
		authorities = Collections.singleton(new SimpleGrantedAuthority(admin.getRole()));
	}


	//获取用户权限信息
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	//账号是否过期，默认是false，记得改
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//账号是否锁定，默认false,记得改
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//账号凭证是否过期，默认是false，记得改
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	//是否可用，默认false，记得改
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "JwtUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", authorities=" + authorities +
				'}';
	}


}
