package com.ww.message.mapper;

import com.ww.message.pojo.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Insert("insert into message (content, user_id, create_time) values (#{content}, #{userId}, #{createTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addMessage(Message message);

    @Select("select * from message")
    List<Message> getMessageList();

    @Select("select * from message where user_id=#{userId}")
    List<Message> getMessageListByUserId(Integer userId);

    @Delete("delete from message where id=#{id} and user_id=#{userId}")
    int deleteMessageByIdAndUserId(@Param("id") Integer id, @Param("userId") Integer userId);
}
