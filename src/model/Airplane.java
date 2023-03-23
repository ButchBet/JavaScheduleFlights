package model;

public class Airplane {
    private String name;
    private boolean state;
    private int capacity;
    private String SN;
    
    public Airplane(){}

    public Airplane(String name, boolean state, int capacity, String SN) {
        this.name = name;
        this.state = state;
        this.capacity = capacity;
        this.SN = SN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }
    
    public String toString() {
        return ("Name: " + name + " - State: " + state + " - Capacity: " + capacity + " - SN: " + SN);
    }
}
