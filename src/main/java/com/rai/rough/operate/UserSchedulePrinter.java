package com.rai.rough.operate;

import com.rai.rough.model.User;

public class UserSchedulePrinter {
    public void printSchedule(User user) {
        user.getSchedule().printSchedule();
    }
}
