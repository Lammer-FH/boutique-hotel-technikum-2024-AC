package org.technikum.backend.dto;

public class GuestDTO {
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateEmail(String email) {
        this.email = email;
    }
}
