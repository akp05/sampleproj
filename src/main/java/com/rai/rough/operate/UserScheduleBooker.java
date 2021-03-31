package com.rai.rough.operate;

import com.rai.rough.model.ReservedDateSlot;
import com.rai.rough.model.Schedule;
import com.rai.rough.model.SlotInfo;
import com.rai.rough.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class UserScheduleBooker {
    public void createAndBookSchedule(User user) throws ParseException {
        Scanner s = new Scanner(System.in);
        ReservedDateSlot reservedDateSlot = new ReservedDateSlot();
        SlotInfo slotInfo = new SlotInfo();

        System.out.println("Please enter the Start Date for the activity, in the format dd/MMM/yyyy ");
        String startDate = s.nextLine();
        System.out.println("Please enter the Start Time for the activity, in the format HH:mm ");
        String startTime = s.nextLine();
        System.out.println("Please enter the End Date for the activity, in the format dd/MMM/yyyy ");
        String endDate = s.nextLine();
        System.out.println("Please enter the End Time for the activity, in the format HH:mm:ss ");
        String endTime = s.nextLine();
        System.out.println("Please enter the Details of the activity");
        String slotText = s.nextLine();
        System.out.println("Please enter the priority for the activity, (lower the value higher the priority)");
        int taskPriority = s.nextInt();

        slotInfo.setPriority(taskPriority);
        slotInfo.setText(slotText);

        reservedDateSlot.setDateStart(new SimpleDateFormat("dd/MMM/yyyy HH:mm").parse(startDate + " " + startTime));
        reservedDateSlot.setDateEnd(new SimpleDateFormat("dd/MMM/yyyy HH:mm").parse(endDate + " " + endTime));

        if(user.getSchedule().getDateSet().containsKey(reservedDateSlot)) {
            user.getSchedule().getDateSet().get(reservedDateSlot).add(slotInfo);
        }
        else {
            Schedule schedule = new Schedule();
            TreeMap<ReservedDateSlot, TreeSet<SlotInfo>> dateSet= new TreeMap<>();
            TreeSet<SlotInfo> slotInfoSet = new TreeSet<>();
            slotInfoSet.add(slotInfo);
            dateSet.put(reservedDateSlot, slotInfoSet);
            schedule.setDateSet(dateSet);
        }
    }
}
