package com.rai.rough.dataService;

import com.rai.rough.model.User;

import java.util.TreeMap;

public class UsernamePasswordMap {
    private static TreeMap<String, String> userNamePasswordMap;
    private static TreeMap<String, User> userNameUserMap;


    public static TreeMap<String, User> getUserNameUserMap() {
        return userNameUserMap;
    }

    public static TreeMap<String, String> getuserNamePasswordMap() {
        return userNamePasswordMap;
    }
    
    public static void addUserNamePasswordEntry(String userName, String password, User newUser) {
        getuserNamePasswordMap().put(userName, password);
        getUserNameUserMap().put(userName, newUser);
    }    
    
    public static User getUser(String userName) {
        return userNameUserMap.get(userName);
    }

    public static boolean userNameExists(String userName) {
        return userNamePasswordMap.containsKey(userName);
    }

    public static String getUserPassword(String userName) {
        return userNamePasswordMap.get(userName);
    }
}
