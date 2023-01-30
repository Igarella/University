package org.example.company.DTO;
import java.util.UUID;

public class Phone {
    private final UUID id;
    private int prefixCountry;
    private String numberPhone;
    private String typePhone;
    private UUID StudentId;

    public Phone(int prefixCountry, String numberPhone, String typePhone, UUID studentId) {
        this.id = UUID.randomUUID();
        this.prefixCountry = prefixCountry;
        this.numberPhone = numberPhone;
        this.typePhone = typePhone;
        this.StudentId = studentId;
    }

    public Phone(UUID id, int prefixCountry, String numberPhone, String typePhone, UUID studentId) {
        this.id = id;
        this.prefixCountry = prefixCountry;
        this.numberPhone = numberPhone;
        this.typePhone = typePhone;
        StudentId = studentId;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", prefixCountry=" + prefixCountry +
                ", numberPhone='" + numberPhone + '\'' +
                ", typePhone='" + typePhone + '\'' +
                ", StudentId=" + StudentId +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public int getPrefixCountry() {
        return prefixCountry;
    }

    public void setPrefixCountry(int prefixCountry) {
        this.prefixCountry = prefixCountry;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(String typePhone) {
        this.typePhone = typePhone;
    }

    public UUID getStudentId() {
        return StudentId;
    }

    public void setStudentId(UUID studentId) {
        this.StudentId = studentId;
    }
}
