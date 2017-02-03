package com.company;

import java.util.ArrayList;

public class MessageList {
    public ArrayList<Message> AllMessages=new ArrayList<Message>();

    private String number;

    public MessageList(String number){

        this.number=number;
    }
    public void add(Message msg){
        int indx=0;
        for (Message m:AllMessages) {
            if (msg.timestamp.compareTo(m.timestamp)<0)
                break;
            indx++;
        }
        AllMessages.add(indx,msg);
    }
    public void remove(int i){
        AllMessages.remove(i-1);


    }
    public void display(){
        System.out.println("Conversation With: "+number);
        for (Message m:AllMessages) {
            System.out.println(m.Sender+": "+m.getText());
        }

    }
    public void move(int indx, MessageList ml){
        Message m=this.AllMessages.get(indx);
        if(ml!=null){
            ml.add(m);
            this.remove(indx);
        }
        else{
            System.out.println("The conversation you are sending a message to does not exist.");
        }
    }

    public String getName(){
        return number;
    }

}
