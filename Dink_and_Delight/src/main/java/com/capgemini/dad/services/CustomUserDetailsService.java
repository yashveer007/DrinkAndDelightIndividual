package com.capgemini.dad.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.dad.dao.UserRepository;
import com.capgemini.dad.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    
    

	/*
	 * @PostConstruct public void initUsers() { List<User> users = Stream.of( new
	 * User(101, "javatechie", "password", "javatechie@gmail.com"), new User(102,
	 * "user1", "pwd1", "user1@gmail.com"), new User(103, "user2", "pwd2",
	 * "user2@gmail.com"), new User(104, "user3", "pwd3", "user3@gmail.com")
	 * ).collect(Collectors.toList()); repository.saveAll(users); }
	 */
    
    
    
    public List<User> getAllUsers() { 
    	
    	List<User> users = new ArrayList<>();
    	repository.findAll()
    	.forEach(users::add); 
    	return users; 
    	}
	
	  public void addUser (User user) {
	  
	  repository.save(user);
	  
	  }
    
// requesting username (header) & fetching user object from db & providing it to spring security for validation    
        
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
