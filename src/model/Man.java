package model;

import java.time.LocalDate;

public class Man {
    private String lastName;
    private String firstName;
    private String patronymicName;
    private LocalDate birthdate;
    private long phoneNumber;
    private char gender;

    public Man(String lastName, String firstName, String patronymicName, LocalDate birthdate, char gender, long phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Человек: " +
                "Фамилия='" + lastName + '\'' +
                ", Имя='" + firstName + '\'' +
                ", Отчество='" + patronymicName + '\'' +
                ", дата рождения=" + birthdate +
                ", номер=" + phoneNumber +
                ", пол=" + gender +
                ";";
    }
}
