package org.example.dbase.service;

import com.google.gson.Gson;
import org.example.dbase.mapper.MessageMapper;
import org.example.dbase.model.Message;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;
    public List<Message> findContext(Message message){
        List<Message>list=messageMapper.selectByPid(message.getId());
        for (Message mes:list) {
            List<Message>childMessage=findContext(mes);
            mes.setChildcontext(childMessage);
        }
        return list;
    }
    public boolean isAddMessage(Message message ){
        return messageMapper.addMessage(message.getId(),message.getUsername(),message.getContext(),message.getPid());
    }
    public String jsonToString(Message message){
        Gson gson=new Gson();
        List<Message>list=findContext(message);
        return gson.toJson(list);
    }
}
