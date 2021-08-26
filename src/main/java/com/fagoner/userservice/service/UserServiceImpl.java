package com.fagoner.userservice.service;

import com.fagoner.userservice.domain.Role;
import com.fagoner.userservice.domain.User;
import com.fagoner.userservice.repo.RoleRepo;
import com.fagoner.userservice.repo.UserRepo;
import com.fagoner.userservice.repo.UserRoleRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private UserRoleRepo userRoleRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            List<Role> roles = userRoleRepo.getRolesByUserId(user.getId());
            roles.forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }

    }

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        return user;
    }

    @Override
    public Role saveRole(Role role) {
        this.roleRepo.save(role);
        return role;
    }

    @Override
    public void addRoleToUser(int userId, int roleId) {
        if (userRepo.getById(userId) == null)
            throw new RuntimeException("user not found");
        if (roleRepo.getById(roleId) == null)
            throw new RuntimeException("role not found");
        this.userRoleRepo.addRoleToUser(userId, roleId);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.getUsers();
    }

    @Override
    public List<Role> getRolesByUserId(int userId) {
        return userRoleRepo.getRolesByUserId(userId);
    }

    @Override
    public User getUser(String username) {
        return userRepo.getByUsername(username);
    }

}
