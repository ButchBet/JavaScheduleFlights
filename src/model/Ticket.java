package model;

public class Ticket {
    private String ID;
    private double cost;
    private boolean state;
    private String firstName;
    private String lastName;
    private String userID;
    private boolean category;

    public Ticket(String ID, double cost, boolean state, String firstName, String lastName, String userID, boolean category) {
        this.ID = ID;
        this.cost = cost;
        this.state = state;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.category = category;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isCategory() {
        return category;
    }

    public void setCategory(boolean category) {
        this.category = category;
    }
}
