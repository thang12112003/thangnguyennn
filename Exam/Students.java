package Exam;

import java.io.Serializable;

public class Students implements Serializable {
    public Integer enrolID;
    public String firstName;
    public String lastName;
    public Integer age;

    public Students(Integer enrolID, String firstName, String lastName, Integer age) {
        this.enrolID = enrolID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getEnrolID() {
        return enrolID;
    }

    public void setEnrolID(Integer enrolID) {
        this.enrolID = enrolID;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}