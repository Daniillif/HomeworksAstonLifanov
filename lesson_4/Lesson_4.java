package lesson_4;

public class Lesson_4 {
    public static void main(String[] args) {
        Person emp1 = new Person("Lifanov Daniil Petrovich", "QA ingeneer",
                "lifanovdaniil@gmail.com", "+7999 999 99 99",
                150000.00, 26);
        emp1.dataOfPerson();

        //Создать массив из 5 сотрудников.
        //Пример:
        //// вначале объявляем массив объектов
        //Person[] persArray = new Person[5];
        //// потом для каждой ячейки массива задаем объект
        //persArray[0] = new Person("Ivanov Ivan", "Engineer",
        //               "ivivan@mailbox.com", "892312312", 30000, 30);
        //persArray[1] = new Person(...);
        //...
        //persArray[4] = new Person(...);
        Person[] persArray = new Person[5];
        persArray[0] = emp1;
        persArray[1] = new Person("Ivanov Petr Daniilovich", "QT junior",
                "ptpt@mail.ru", "+7999 888 77 66",
                35000, 21);
        persArray[2] = new Person(" Moiseev Kirill Ivanovich", "QA senior",
                "super@mail.ru", "+7999 353 54 54",
                200000, 25);
        persArray[3] = new Person("Gromov Sergey Arturovich", "Java middle",
                "javamyprofession@bk.ru", "+7927 004 99 33",
                180000, 32);
        persArray[4] = new Person("Maslenokov Dmitriy Aleksandrovich", "C++ techLead",
                "cccrule@vk.com", "+7999 887 77 66",
                300000, 45);

        Person.dataOfArrayPerson(persArray);

        Park.Attraction attraction1 = new Park.Attraction("Hvatayka","10:00-12:00",150.0);
        Park park = new Park("Park Pobedy", new Park.Attraction[]{attraction1});
        System.out.println(park.toString());
        System.out.println(attraction1.toString());

    }
}
