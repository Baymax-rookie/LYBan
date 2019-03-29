package org.example.dbase.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.dbase.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MessageMapper {
    @Insert("insert into user set id=#{id},"+
            "username=#{username},"+
            "text=#{text},"+
            "pid=#{pid}")
    Boolean addMessage(@Param("id")int id,@Param("username")String username,@Param("text")String text,@Param("pid")int pid);
    @Select("select * from user where id=#{id}")
    List<Message> selectByPid(@Param("pid")int pid);

}
