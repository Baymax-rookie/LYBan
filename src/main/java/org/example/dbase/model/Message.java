package org.example.dbase.model;

import lombok.Data;

import java.util.List;

@Data
public class Message {
    private int id;
    private String username;
    private int pid;
    private String context;
    private List<Message> childcontext;

    public Message(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Message> getChildcontext() {
        return childcontext;
    }

    public void setChildcontext(List<Message> childcontext) {
        this.childcontext = childcontext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Message(int id, String username, int pid, String context){
        this.id=id;
        this.username=username;
        this.pid=pid;
        this.context=context;
    }
    public String toString(){
        return "Message{"+
                "id="+id+
                ", username=\""+username+'\"'+
                ", context=\""+context+"\""+
                '}';
    }

    public static void main(String[] args) {
        Message message = new Message(12, "hj",10, "dsfsd3a21");
        System.out.println(message.toString());
    }
}
