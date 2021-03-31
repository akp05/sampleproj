package com.rai.rough.model;

import java.util.Date;

public class ReservedDateSlot implements Comparable<ReservedDateSlot> {
    private Date dateStart;
    private Date dateEnd;

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public int compareTo(ReservedDateSlot object) {
        return this.dateStart.compareTo(object.dateStart);
    }
}
