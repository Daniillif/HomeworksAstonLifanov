package lesson_4;

//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
public class Person {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private double payroll;
    private int age;

    //Конструктор класса должен заполнять эти поля при создании объекта.
    public Person(String fio, String position,
                    String email, String phone,
                    double payroll, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.payroll = payroll;
        this.age = age;
    }
    //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

    public void dataOfPerson(){
        System.out.println( "Person:" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", payroll=" + payroll +
                ", age=" + age + ";");
    }
    }

