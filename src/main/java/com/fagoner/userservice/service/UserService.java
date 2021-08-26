package com.fagoner.userservice.service;

import com.fagoner.userservice.domain.Role;
import com.fagoner.userservice.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(int userId, int roleid);

    List<User> getUsers();

    List<Role> getRolesByUserId(int userId);

    User getUser(String username);
}
