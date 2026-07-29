/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Student {
    private int studentID;
    private String name;
    private University university;

    public Student(int studentID, String name, University university) {
        this.studentID = studentID;
        this.name = name;
        this.university = university;
    }
}
