package Exam_14_December_2022.SoftUnisStudents.softUni;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;

public class SoftUni {
    //capacity: int
    //data: List<Student> - holds all added students in the hall
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //getCapacity()
    public int getCapacity() {
        return this.capacity;
    }

    //getCount() method – returns the number of students in the course.

    public int getCount() {
        return this.data.size();
    }


    //insert(Student student) method – adds an entity to the data if there is a hall for it.
    public String insert(Student student) {
        //Returns "The hall is full." - if the hall is full.
        if (this.capacity == this.data.size()) {
            return "The hall is full.";
        } else if (this.data.contains(student)) {
            //Returns "Student is already in the hall." –  if the student is already in the hall.
            return "Student is already in the hall.";
        } else {
            this.data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }

    }

    //remove(Student student) method – removes the student
    public String remove(Student student) {
        if (this.data.contains(student)) {
            //Returns "Removed student {firstName} {lastName}." –  if the student is successfully removed.
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            //Returns "Student not found." if the student is not in the hall.
            return "Student not found.";
        }

    }

    //getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName) {
        Student student;
        for (int i = 0; i < this.data.size(); i++) {
            student = this.data.get(i);
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                //Student: Alex Raykova, Best Course – Python
                return student;
            }
        }
        return null;
    }

    //getStatistics() – returns a String in the following format:
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        //"Hall size: {addedStudentsCount}
        text.append(String.format("Hall size: %d", this.data.size()));
        text.append(System.lineSeparator());
        this.data.forEach(e -> {
            text.append(e.toString());
            text.append(System.lineSeparator());
        });
        // Student: {firstName} {lastName}, Best Course = {bestCourse}
        // Student: {firstName} {lastName}, Best Couse = {bestCourse}
        // (…)"
        return text.toString();
    }
}
