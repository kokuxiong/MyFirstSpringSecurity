package com.koku.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//no use for now
//@Component
public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		String password = passwordEncoder.encode("123456");
//		User user = new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//		return user;
//	}
	
}
