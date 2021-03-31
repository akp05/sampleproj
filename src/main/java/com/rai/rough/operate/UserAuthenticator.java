package com.rai.rough.operate;

import static com.rai.rough.dataService.UsernamePasswordMap.getUserPassword;
import static com.rai.rough.dataService.UsernamePasswordMap.userNameExists;

public class UserAuthenticator {
    public boolean authenticate(String username, String password) {
        if(userNameExists(username) && getUserPassword(username).equals(password))
            return true;
        return false;
    }
}
