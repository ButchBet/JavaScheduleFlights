package model;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private Long ID;
    
    public User(){}

    public User(String firstName, String lastName, int age, Long ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ID = ID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    public String toString() {
        return "Name: " + firstName + " " + lastName + " - Age: " + age + " - ID: " + ID;
    }
}
