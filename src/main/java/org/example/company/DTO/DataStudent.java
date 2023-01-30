package org.example.company.DTO;

public class DataStudent {
    private Student student;
    private String subject;
    private int mark;
    private String teacher;

    public DataStudent(Student student, String subject, int mark, String teacher) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "DataStudent{" +
                "student=" + student +
                ", subject='" + subject + '\'' +
                ", mark=" + mark +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
