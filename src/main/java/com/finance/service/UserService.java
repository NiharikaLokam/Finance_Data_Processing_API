package com.finance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finance.entity.Role;
import com.finance.entity.User;
import com.finance.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User updateRole(Long id, String role) {
        User user = repo.findById(id).orElseThrow();
        user.setRole(Role.valueOf(role));
        return repo.save(user);
    }
    
}
