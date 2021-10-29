package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.Entity.User;
//import com.Repository.UserRepository;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepository userRepo;
     
    public List<User> listAll() {
        return userRepo.findAll();
    }
     
    public void save(User user) {
    	userRepo.save(user);
    }
     
    public User get(long userId) {
        return userRepo.findById(userId).get();
    }
     
    public void delete(long userId) {
    	userRepo.deleteById(userId);
    }
}
