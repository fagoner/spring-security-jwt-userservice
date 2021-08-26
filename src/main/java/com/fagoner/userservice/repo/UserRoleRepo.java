package com.fagoner.userservice.repo;

import com.fagoner.userservice.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleRepo {

    @Insert(
            {
                    "INSERT INTO userservice.user_role(user_id, role_id) ",
                    "VALUES (#{userId}, #{roleId});"
            }
    )
    void addRoleToUser(int userId, int roleId);

    @Select(
            {
                    "SELECT r.id AS id, r.name AS name ",
                    "FROM role r ",
                    "INNER JOIN userservice.user_role AS u_r ON u_r.user_id = #{userId} ",
                    "AND r.id = u_r.role_id;"
            }
    )
    List<Role> getRolesByUserId(int userId);

}
