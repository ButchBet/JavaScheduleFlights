package model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private Long ID;
    
    public User(){}

    public User(String firstName, String lastName, String email, String password, int age, Long ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    public String toString() {
        return "\nName: " + firstName + " " + lastName + " - Email: " + email +  " - Age: " + age + " - ID: " + ID;
    }
}
