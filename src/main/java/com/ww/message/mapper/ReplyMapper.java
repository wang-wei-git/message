package com.ww.message.mapper;

import com.ww.message.pojo.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Insert("insert into reply (content, user_id, message_id, create_time) values (#{content}, #{userId}, #{messageId}, #{createTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addReply(Reply reply);

    @Select("select * from reply where message_id=#{messageId}")
    List<Reply> getReplyListByMessageId(Integer messageId);
}
