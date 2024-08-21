package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Service {
    private String [] answerArray;
    public String [] answerToArray(String answer){
        answerArray = answer.split(" ");
        return answerArray;
    }

    public boolean checkAnswer (String [] answerArray) throws InvalidInputSizeException{
        if(answerArray.length == 6){
            return true;
        }
        else {
            throw new InvalidInputSizeException("Неверное количество параметров");
        }
    }

    public boolean checkText (String partAnswer) throws InvalidInputSizeException, IllegalArgumentException {
        char[] arrChars = partAnswer.toCharArray();
        if (arrChars.length <= 2){
            throw new InvalidInputSizeException("Неверное количество букв в слове, должно быть 3 и больше");
        }
        else {
            for (int i = 0; i < arrChars.length; i++) {
                if (Character.isDigit(arrChars[i])) {
                    throw new IllegalArgumentException("Неверный ввод текста");
                }

            }
            return true;
        }
    }

    public String getLastName (String [] answerArray) throws InvalidInputSizeException, IllegalArgumentException {
        String lastName = answerArray[0];
        if (checkText(lastName)){
            return lastName;
        }
        else{
            return null;
        }
    }

    public String getFirstName (String [] answerArray) throws InvalidInputSizeException, IllegalArgumentException {
        String firstName = answerArray[1];
        if (checkText(firstName)){
            return firstName;
        }
        else{
            return null;
        }
    }

    public String getPatronynicName (String [] answerArray) throws InvalidInputSizeException, IllegalArgumentException {
        String patronymicName = answerArray[2];
        try{ checkText(patronymicName);
            return patronymicName;
        }
        catch
        (IllegalArgumentException | InvalidInputSizeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public LocalDate getBirthDate (String [] answerArray) throws DateTimeParseException {
        String dateString = answerArray[3];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try{
            return LocalDate.parse(dateString, formatter);
        }
        catch (DateTimeParseException e){
            throw e;
        }
    }

    public Character getGender(String [] answerArray) throws InvalidInputSizeException, IllegalArgumentException{
        String genderString = answerArray[4];
        if (genderString.length()!=1){
            throw new InvalidInputSizeException("Неверное количество букв в гендере, должна быть одна");
        }
        else {
            char gender = genderString.charAt(0);
            if(gender!= 'f' && gender!= 'm'){
                throw new IllegalArgumentException("при указании пола допустимы только символы f и m");
            }
            else{
                return gender;
            }
        }
    }

    public Long getPhoneNumber(String [] answerArray) throws InvalidInputSizeException, IllegalArgumentException {
        String phoneNumberString = answerArray[5];
        if (phoneNumberString.length() < 6) {
            throw new InvalidInputSizeException("Неверное количество цифр в телефоне, должно быть шесть");
        } else {
            try{
                long number = Integer.parseInt(phoneNumberString);
                return number;
            }
            catch (IllegalArgumentException e){
                throw e;
            }
        }
    }
    public void save(ArrayList <Man> mans){
        StringBuilder sb = new StringBuilder();
        for (Man man : mans) {
            sb.append(man);
            sb.append("\n");
        }
        try(FileWriter writer = new FileWriter("notes3.txt", true)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("не удалось записать в файл" + e.getMessage());
        }
    }
}
