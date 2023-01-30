package org.example.company.DTO;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private final UUID id;
    private String email;
    private UUID studentId;
    private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public Email(String email, UUID studentId) {
        this.id = UUID.randomUUID();
        this.studentId = studentId;
        if (validateEmail(email)) {
            this.email = email;
        } else {
            this.email = "";
        }
    }

    public Email(UUID id, String email, UUID studentId) {
        this.id = id;
        this.email = email;
        this.studentId = studentId;
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", studentId=" + studentId +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getEmailPattern() {
        return emailPattern;
    }

    public void setEmailPattern(String emailPattern) {
        this.emailPattern = emailPattern;
    }
}
