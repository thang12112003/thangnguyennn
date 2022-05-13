package Exam;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Students> studentList;
    private StudentDoc studentDoc;

    public StudentManager() {
        studentDoc = new StudentDoc();
        studentList = studentDoc.read();
    }

    public void add() throws IOException {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " + id);
        String firstName = inputFirstName();
        String lastName = inputLastName();
        byte age = inputAge();
        Students student = new Students(id,firstName,lastName,Integer.parseInt(String.valueOf(age)));
        studentList.add(student);
        studentDoc.write(studentList);
    }

    public void show() {
        for (Students student : studentList) {
            System.out.format("%5d | ", student.getEnrolID());
            System.out.format("%20s | ", student.getFirstName());
            System.out.format("%20s | ", student.getLastName());
            System.out.format("%5d | ", student.getAge());

        }
    }

    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }
    private byte inputAge() {
        System.out.print("Input student age: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    private String inputFirstName() {
        System.out.print("Input student fname: ");
        return scanner.nextLine();
    }
    private String inputLastName() {
        System.out.print("Input student lname: ");
        return scanner.nextLine();
    }
    public List<Students> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Students> studentList) {
        this.studentList = studentList;
    }

}