package com.rai.rough.operate;

import com.rai.rough.dataService.UsernamePasswordMap;
import com.rai.rough.model.User;

public class LogInUser {
    public User logInUser(String userName, String password) {
        UserAuthenticator userAuthenticator = new UserAuthenticator();
        if(userAuthenticator.authenticate(userName, password)) {
            return UsernamePasswordMap.getUser(userName);
        }
        return null;
    }
}
