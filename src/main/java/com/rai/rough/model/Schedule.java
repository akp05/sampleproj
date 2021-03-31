package com.rai.rough.model;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
this Object will retain all the booked slots with schedule information as a string
 */
public class Schedule {
    //todo: get these details from DB.
    private TreeMap<ReservedDateSlot, TreeSet<SlotInfo>> dateSet;

    public TreeMap<ReservedDateSlot, TreeSet<SlotInfo>> getDateSet() {
        return dateSet;
    }

    public void setDateSet(TreeMap<ReservedDateSlot, TreeSet<SlotInfo>> dateSet) {
        this.dateSet = dateSet;
    }

    public void printSchedule() {
        //todo: print only next n days' schedule.
        System.out.println("Hi I am Skeddy, here's your complete schedule:");
        for(Map.Entry<ReservedDateSlot, TreeSet<SlotInfo>> entry : this.dateSet.entrySet()) {
            int taskCounter = 1;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm");
            System.out.println("\n********** " + dtf.format((TemporalAccessor) entry.getKey().getDateStart()) + " **********");
            for(SlotInfo slotInfo: entry.getValue()) {
                System.out.println("\t" + taskCounter + ": " + slotInfo.getText() + " with a priority of: " + slotInfo.getPriority());
            }
            System.out.println("********** " + dtf.format((TemporalAccessor) entry.getKey().getDateEnd()) + " **********\n\n\n\n\n");
        }
    }
}