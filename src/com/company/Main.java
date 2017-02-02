package com.company;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in) ;
    private static ArrayList<MessageList> ListOMessages=new ArrayList<MessageList>();
    public static void main(String[] args) {

        int choose=-1;
        boolean truth=true;
        System.out.println("Welcome to Messenger0.3.");
        while(truth){
            choose=-1;
            System.out.println("\nYour options are: \n1)Sending a Message\n2)Reading Messages\n3)Moving Messages\n4)Removing Messages\n5)Exit\n");
           while (choose==-1) {
               choose = numberCheck(1, 5);
           }
            switch(choose) {
                case 1:
                    System.out.println("Enter the number you would like to message: ");
                    String PhoneNumber = "";
                    while (PhoneNumber.length() == 0) {
                        PhoneNumber = sc.nextLine();
                    }
                    System.out.println("Now enter your message: ");
                    String text = sc.nextLine();
                    boolean b = false;
                    for (MessageList M : ListOMessages) {
                        b = M.getName().equalsIgnoreCase(PhoneNumber);
                        if (b) {
                            M.add(new Message(text, PhoneNumber, "You"));
                            break;
                        }

                    }
                    if (!b) {
                        ListOMessages.add(new MessageList(PhoneNumber));
                        ListOMessages.get(ListOMessages.size() - 1).add(new Message(text, PhoneNumber, "You"));
                    }
                    break;

                case 2:
                    System.out.println("Which conversation do you want to view? ");

                    String number = "";
                    while (number.length() == 0) {
                        number = sc.nextLine();
                    }
                    System.out.println();
                    int find = FindList(number);
                    if (find < 0) {
                        System.out.println("You have not started a conversation with that person.");
                    } else {
                        ListOMessages.get(find).display();
                    }
                    break;

                case 3:
                    System.out.println("Enter the contact for the message you want to move: ");

                    String original = "";
                    while(original.length()==0){
                        original=sc.nextLine();
                    }

                    int num1=FindList(original);
                    System.out.println("Enter the number of the message you want to move(i.e. The top message is 1, the second message down is 2,...)\n");

                    int indx= numberCheck(1,-1);
                    System.out.println("Enter the contact of the conversation you want the message moved to: ");
                    String toArl="";
                    while (toArl.length()==0){
                        toArl=sc.nextLine();
                    }
                    int num2=FindList(toArl);
                    if(num1<0||num2<0){
                        System.out.println("The provided information was invalid.\nThe Original conversation does not exist.");
                    }
                    else if(indx>ListOMessages.get(num1).AllMessages.size()){
                        System.out.println("The provided information was invalid.\nThe Message index was not valid.");
                    }
                    else{
                        ListOMessages.get(num1).move(indx-1,ListOMessages.get(num2));
                    }
                    break;
                case 4:
                    System.out.println("Would you like to:\n1)Delete 1 message\n2)Delete a conversation\n\n");
                    int del=numberCheck(1,2);
                    switch (del){
                        case 1:
                            System.out.println("Which conversation is the message in: ");
                            String num="";
                            while (num.length()==0) {
                                num=sc.nextLine();
                            }
                            int index= FindList(num);
                            if (index>-1){
                                System.out.println("Which message number should be removed(i.e. The top message is 1, the second message down is 2,...)?\n");
                                int msg=numberCheck(1,ListOMessages.get(index).AllMessages.size());
                                ListOMessages.get(index).AllMessages.remove(index);
                            }
                            else
                                System.out.println("That conversation does not exist yet.");
                            break;
                        case 2:
                            System.out.println("Which conversation do you want to delete? ");
                            String deletingNum="";
                            while(deletingNum.length()==0){
                                deletingNum=sc.nextLine();
                            }
                            int DeletingIndex=FindList(deletingNum);
                            if (DeletingIndex>-1){
                                System.out.println("Are you sure?");
                                deletingNum="";
                                while(deletingNum.length()==0){
                                    deletingNum=sc.next();
                                }
                                if(deletingNum.equalsIgnoreCase("yes")) {
                                    ListOMessages.get(DeletingIndex).AllMessages.clear();
                                    ListOMessages.remove(DeletingIndex);
                                }
                            }
                            else
                                System.out.println("That conversation does not exist yet.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Goodbye.\n\nMessenger0.3 Shutting down");
                    truth=false;
                    break;

            }
        }

    }
    public static int numberCheck(int lower,int upper){
       int i=-1;
        if(lower>upper){
            while(i<lower){
                i=aGoodTry();
                if(1<lower)
                    System.out.println("That number is not valid.\n");
            }
        }
        else {
            while (i >upper || i < lower) {
                i=aGoodTry();
                if(1<lower||i>upper)
                    System.out.println("That number is not valid.\n");
            }
        }
        return i;
    }
    public static int aGoodTry(){
        int i=-1;
        try{
                i = Integer.parseInt(sc.next());
        }
        catch(InputMismatchException a){
            System.out.println("That was not a valid integer, Try Again:");
        }
        catch(NumberFormatException n){
            System.out.println("That was not a valid integer, Try Again:");
        }
        return i;
    }
    public static int FindList(String num){
        int find=-1;
        for (int i=0;i<ListOMessages.size();i++) {
            if(ListOMessages.get(i).getName().equalsIgnoreCase(num))
                find=i;
        }

        return find;
    }
}
