package com.rai.rough.operate;

import com.rai.rough.dataService.UsernamePasswordMap;
import com.rai.rough.model.User;

import java.util.Scanner;

public class UserCreator {

    public static void createUser() {
        Scanner s = new Scanner(System.in);
        String userName;
        do {
            System.out.println("Enter Username:");
            userName = s.nextLine();
        } while(UsernamePasswordMap.userNameExists(userName));
        System.out.println("Enter Password: ");
        String password = s.nextLine();
        System.out.println("Enter Email ID: ");
        String email = s.nextLine();

        User newUser = new User().withEmail(email).withUserName(userName);
        UsernamePasswordMap.addUserNamePasswordEntry(userName, password, newUser);
    }
}
