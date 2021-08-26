package com.fagoner.userservice.repo;

import com.fagoner.userservice.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepo {

    @Insert("INSERT INTO userservice.user (name, username, password) VALUES (#{name}, #{username}, #{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);

    @Select("SELECT * FROM userservice.user WHERE id = #{id}")
    User getById(int id);

    @Select("SELECT * FROM userservice.user WHERE username = #{username}")
    User getByUsername(String username);

    @Select("SELECT id, name, username FROM userservice.user;")
    List<User> getUsers();

}
