package com.arkham.gradeview.gradeview;


public class Grade {
    private int id;
    private String subject;
    private String grade;
    private int ects;
    private int chours;
    private String type;


    public Grade(int id, String subject, String grade, int ects, int chours, String type) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
        this.ects = ects;
        this.chours = chours;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public int getEcts() {
        return ects;
    }

    public int getChours() {
        return chours;
    }

    public String getType() {
        return type;
    }
}
