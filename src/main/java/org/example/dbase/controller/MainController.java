package org.example.dbase.controller;

import org.apache.ibatis.annotations.Param;
import org.example.dbase.model.Message;
import org.example.dbase.service.MessageService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private MessageService service;
    @PostMapping(value = "hello",produces = "application/json")
    public String hello(JSONObject json){
        return json.toString();
    }
    @GetMapping(value = "insert")
    public boolean selectUser(@Param("id")int id,@Param("username")String username,@Param("text")String text,@Param("pid")int pid){
        Message message=new Message(id,username,pid,text);
        return service.isAddMessage(message);
    }
    @GetMapping(value = "message",produces = "application/json")
    public String user(Message message){
        return this.service.jsonToString(message);
    }
}
