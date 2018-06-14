package com.example.multisource.dao.user;

import com.example.multisource.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name) values(#{user.name})")
    @Options(useGeneratedKeys = true,keyProperty = "user.id")
    int insert(@Param("user")User user);
}
