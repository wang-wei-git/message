package com.ww.message.mapper;

import com.ww.message.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username, password) values (#{username}, #{password})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(User user);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);
}