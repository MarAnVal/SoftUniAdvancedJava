package Exam_14_April_2021.University;

import java.util.ArrayList;
import java.util.List;

public class University {
    //capacity: int
    private int capacity;
    //students: List<Student> - holds all added students in the university
    private List<Student> students;

    //constructor should receive (capacity), also it should initialize
    // the students with a new instance of the collection.

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }
    //getCapacity()

    public int getCapacity() {
        return capacity;
    }

    //getStudents()

    public List<Student> getStudents() {
        return students;
    }

    //getStudentCount() method– returns the number of students in the university
    public int getStudentCount() {
        return this.students.size();
    }

    //registerStudent(Student student) method – adds an entity to the students if there is room for it
    //Returns "Added student {firstName} {lastName}" if the student is successfully added
    //Returns "Student is already in the university" if the student is already in the university
    //Returns "No seats in the university" if the university is full
    public String registerStudent(Student student) {
        for (int i = 0; i < this.students.size(); i++) {
            Student current = this.students.get(i);
            if (current.firstName.equals(student.firstName) &&
                    current.lastName.equals(student.lastName) &&
                    current.bestSubject.equals(student.bestSubject)) {
                return "Student is already in the university";
            }
        }
        if (this.capacity > this.students.size()) {
            this.students.add(student);
            return String.format("Added student %s %s", student.firstName, student.lastName);
        }
        return "No seats in the university";
    }

    //dismissStudent(Student student) method – removes the student
    //Returns "Student not found" if the student is not in the university

    public String dismissStudent(Student student) {
        for (int i = 0; i < this.students.size(); i++) {
            Student current = this.students.get(i);
            if (current.firstName.equals(student.firstName) &&
                    current.lastName.equals(student.lastName) &&
                    current.bestSubject.equals(student.bestSubject)) {
                this.students.remove(student);
                return String.format("Removed student %s %s", current.firstName, current.lastName);
            }
        }
        return "Student not found";
    }

    //getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName) {
        for (int i = 0; i < this.students.size(); i++) {
            Student current = this.students.get(i);
            if (current.firstName.equals(firstName) && current.lastName.equals(lastName)) {
                return current;
            }
        }
        return null;
    }

    //getStatistics() – returns a String in the following format:
    //"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
    // ==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
    //   (…)"
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < this.students.size(); i++) {
            Student current = this.students.get(i);
            text.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    current.firstName, current.lastName, current.bestSubject));
            if (i < this.students.size() - 1) {
                text.append(System.lineSeparator());
            }
        }
        return text.toString();
    }

}
