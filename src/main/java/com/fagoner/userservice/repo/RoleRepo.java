package com.fagoner.userservice.repo;

import com.fagoner.userservice.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleRepo {

    @Insert("INSERT INTO userservice.role(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Role role);

    @Select("SELECT * FROM userservice.role WHERE id = #{id}")
    Role getById(int id);

    @Select("SELECT * FROM userservice.role WHERE name = #{name}")
    Role getByName(String name);

}
