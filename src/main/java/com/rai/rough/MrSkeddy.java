package com.rai.rough;

import com.rai.rough.model.User;
import com.rai.rough.operate.LogInUser;
import com.rai.rough.operate.UserScheduleBooker;
import com.rai.rough.operate.UserSchedulePrinter;
import static com.rai.rough.operate.UserCreator.createUser;

import java.text.ParseException;
import java.util.Scanner;

public class MrSkeddy {
    public static void main(String args) throws ParseException {
        User user = new User();
        Scanner s = new Scanner(System.in);
        boolean loggedInFlag = false;
        while(!loggedInFlag) {

            System.out.println("Press 1 to create a new account" +
                    "Press 2 if you already have an account");
            int key = s.nextInt();
            if(key == 1)
                createUser();
            else if(key == 2) {
                LogInUser logInUser = new LogInUser();
                System.out.println("Enter Username:");
                String userName = s.nextLine();
                System.out.println("Enter Password: ");
                String password = s.nextLine();
                user = logInUser.logInUser(userName, password);
                if(user != null) {
                    System.out.println("Welcome " + user.getEmail());
                    loggedInFlag = true;
                }
                else {
                    System.out.println("Login Failed...");
                }
            }
            else {
                System.out.println("Incorrect Key pressed");
            }
        }
        String initial = "Hello I am Mr Skeddy, " +
                "1.\tPress 1 to Book an available slot" +
                "2.\tPress 2 to Print the schedule";
        System.out.println(initial);
        int keypress = s.nextInt();
        while(keypress != 1 && keypress != 2) {
            keypress = s.nextInt();
            if (keypress == 1) {
                UserScheduleBooker userScheduleBooker = new UserScheduleBooker();
                userScheduleBooker.createAndBookSchedule(user);
            } else if (keypress == 2) {
                UserSchedulePrinter userSchedulePrinter = new UserSchedulePrinter();
                userSchedulePrinter.printSchedule(user);
            }
        }
    }
}