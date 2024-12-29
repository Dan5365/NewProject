package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class School {
    List<Person> members = new ArrayList<>();

    public void addMember(Person p) {
        members.add(p);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person p : members) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }


    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person p : members) {
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("Data saved" + fileName);
        } catch (IOException e) {
            System.out.println("Error saving" + e.getMessage());
        }
    }
}
