package com.sw.digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sw.digital.entity.Admin;
import com.sw.digital.entity.JwtUser;
import com.sw.digital.repository.UserRepository;

/**
 * 根据用户名获取用户
 * @author Kyle
 * 使用springSecurity需要实现UserDetailsService接口供权限框架调用，该方法只需要实现一个方法就可以了，
 * 那就是根据用户名去获取用户，那就是上面repository定义的方法了，这里直接调用了。
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Admin admin = userRepository.findByName(s);
		return new JwtUser(admin);
	}
	
	
}
