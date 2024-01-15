package Exam_14_April_2021.University;
public class Student {
    //firstName: String
    public String firstName;
    //lastName: String
    public String lastName;
    //bestSubject: String
    public String bestSubject;

    //The class constructor should receive (firstName, lastName, and bestSubject).

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }
    //getFirstName()

    public String getFirstName() {
        return firstName;
    }
    //getLastName()
    public String getLastName() {
        return lastName;
    }
    //getBestSubject()
    public String getBestSubject() {
        return bestSubject;
    }

    public void setBestSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }
    //Override the toString() method in the following format:
    //"Student: {firstName} {lastName}, {bestSubject}"

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s", this.firstName, this.lastName, this.bestSubject);
    }
}
