package presenter;

import model.InvalidInputSizeException;
import model.Man;
import model.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Presenter {
    private ArrayList <Man> mans;
    private Service service = new Service();
    private String [] answerArray;
    public Presenter(){
        mans = new ArrayList<>();
    }
    public void addMan(String answer){
        answerArray = service.answerToArray(answer);
        try {
            if(service.checkAnswer(answerArray)){
                String firstName = service.getFirstName(answerArray);
                String lastName = service.getLastName(answerArray);
                String patronicName = service.getPatronynicName(answerArray);
                LocalDate birthDate = service.getBirthDate(answerArray);
                char gender = service.getGender(answerArray);
                long phoneNumber = service.getPhoneNumber(answerArray);
                Man man = new Man(lastName, firstName, patronicName, birthDate, gender, phoneNumber);
                mans.add(man);
            }
        } catch (InvalidInputSizeException | IllegalArgumentException | DateTimeParseException  e ) {
            System.out.println("Ошибка:" + e.getMessage());

        }
    }
    public void seeMans(){
        for (Man man : mans) {
            System.out.println(man);
        }
    }
    public void saveAll(){
        service.save(mans);
    }
}

