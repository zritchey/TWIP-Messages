package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in) ;
    private static ArrayList<MessageList> ListOMessages=new ArrayList<MessageList>();
    public static void main(String[] args) {

        int choose=-1;
        while(1==1){
            System.out.println("Welcome to Messenger0.3.\n\n  Your options are: \n1)Sending a Message\n2)Reading Messages\n3)Moving Messages\n4)Removing Messages");
            choose=numberCheck(sc,4,1);
            switch(choose){
                case 1:
                    System.out.println("Enter the number you would like to message: ");
                    String PhoneNumber=sc.nextLine();
                    System.out.println("Now enter your message: ");
                    String text=sc.nextLine();
                    


            }
        }

    }
    public static int numberCheck(Scanner sc, int lower,int upper){
        int i=-1;
        while (i<=upper&&i>=lower){
            try{
                i=sc.nextInt();
            }
            catch(ArithmeticException a){
                System.out.println("That was not a valid integer, Try Again:");
            }
        }
        return i;
    }
}
