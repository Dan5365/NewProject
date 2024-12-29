package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        readFileAndAddMembers("C:/Users/adilb/IdeaProjects/NewProject/src/models/students.txt", school, true);
        readFileAndAddMembers("C:/Users/adilb/IdeaProjects/NewProject/src/models/teachers.txt", school, false);

        // Show all members
        System.out.println("School Members:");
        System.out.println(school);
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
    }

    private static void readFileAndAddMembers(String fileName, School school, boolean isStudent) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];


                int age = 0;
                try {
                    age = Integer.parseInt(data[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age format for: " + name + " " + surname);
                    continue;
                }

                boolean gender = data[2].equalsIgnoreCase("male");

                if (isStudent) {
                    Student student = new Student(name, surname, age, gender);

                    for (int i = 3; i < data.length; i++) {
                        try {
                            student.addGrade(Integer.parseInt(data[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid grade format for student: " + name + " " + surname);
                        }
                    }
                    school.addMember(student);
                } else {
                    String subject = data[3];
                    int experience = 0;
                    int salary = 0;

                    try {
                        experience = Integer.parseInt(data[4]);
                        salary = Integer.parseInt(data[5]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid teacher data for: " + name + " " + surname);
                        continue;  
                    }

                    Teacher teacher = new Teacher(name, surname, age, gender, subject, experience, salary);
                    school.addMember(teacher);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName);
        }
    }
}
