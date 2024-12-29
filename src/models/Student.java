package models;

import java.util.ArrayList;
import java.util.List;

class Student extends Person {
    static int idCounter = 1;
    int studentID;
    List<Integer> grades = new ArrayList<>();

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return grades.size() > 0 ? (double) total / grades.size() : 0;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
