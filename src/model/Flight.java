package model;

import java.util.Date;

public class Flight {
    private boolean state;
    private String from;
    private String to;
    private String airplaneSN;
    private double costFirstClass;
    private double costSecondClass;
    private Date date;
    private int capacity;
    
    public Flight(){}

    public Flight(boolean state, String from, String to, String airplaneSN, double costFirstClass, double costSecondClass, Date date, int capacity) {
        this.state = state;
        this.from = from;
        this.to = to;
        this.airplaneSN = airplaneSN;
        this.costFirstClass = costFirstClass;
        this.costSecondClass = costSecondClass;
        this.date = date;
        this.capacity = capacity;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAirplaneSN() {
        return airplaneSN;
    }

    public void setAirplaneSN(String airplaneSN) {
        this.airplaneSN = airplaneSN;
    }

    public double getCostFirstClass() {
        return costFirstClass;
    }

    public void setCostFirstClass(double cost) {
        this.costFirstClass = cost;
    }
    
    public double getCostSecondClass() {
        return costSecondClass;
    }

    public void setCostSecondClass(double cost) {
        this.costSecondClass = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }  
    
    public String toString() {
        return ("State: " + state + " - From: " + from + " - To:" + to + " - Airplane SN: " + airplaneSN + " - Cost first class: " + costFirstClass + " - Cost second class: " + costSecondClass + " - Date: " + date.toString() + " - Capacity: " + capacity);
    }
}
