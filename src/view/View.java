package view;

import presenter.Presenter;

import java.util.Scanner;

public class View {
    boolean work;
    Scanner scanner;
    Presenter presenter;
    String answer;
    public View() {
        scanner = new Scanner(System.in);
        presenter = new Presenter();
        work = true;
    }
    public void start(){
        while (work){
            System.out.println("Выбери пункт меню:\n 1. Добавить человека\n 2.Сохранить список всех в файл\n 3.Просмотреть список\n 4.Выйти");
            answer = scanner.nextLine();
            if(answer.equals("1")){
                System.out.println("введи фамилию, имя, отчество, дату рождения в формате 11.01.1999, пол (f,m), телефон без спец.символов. Раздели пункты пробелом");
                presenter.addMan(scanner.nextLine());
            }
            else if(answer.equals("2")){
                presenter.saveAll();
                System.out.println("Сохранено в файл");
            }
            else if(answer.equals("3")){
                presenter.seeMans();
            }
            else if(answer.equals("4")){
                work = false;
            }
            else {
                start();
            }
        }
    }

}
