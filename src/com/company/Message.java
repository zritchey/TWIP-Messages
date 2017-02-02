package com.company;


import java.text.*;
import java.util.Date;

/**
 * Created by zr162 on 1/30/17.
 */
public class Message {
    private final String text;
    private final String date;
    private final String  time;
    public final  String timestamp;
    private static String daytime;
    public final String number;
    public final String Sender;

    public Message(String t,String nbr,String Send){
        text=t;
        number=nbr;
        time=findTime();
        date=findDate();
        timestamp= time+" "+daytime+"   "+date;
        Sender=Send;
    }
    static public String findTime(){
        String time=new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
        String[]s=time.split(":");
        int h=Integer.parseInt(s[0]);
        daytime="AM";
        if(h>11){
            if(h!=12)
                h=h%12;
            if (h!=24)
                daytime="PM";
        }
        return h+":"+s[1];
    }
    static public String findDate(){
        DateFormat df=new SimpleDateFormat("MM/dd/yy") ;
        return df.format(new Date());
    }
    public String getText(){
        return text+"\n\t\t"+timestamp;
    }

}