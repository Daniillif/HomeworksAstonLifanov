package lesson_9;

import java.util.*;

public class Lesson_9 {
    public static Collection<Student> students = Arrays.asList(new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN));

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = (int) (Math.random() * 15);
        for (int i = 0; i < n; i++) {
            arr.add((int) (Math.random() * 100));
        }
        System.out.println("Набор случайно сгенерированных чисел:" + arr);
        System.out.println("Результат подсчета 1 задания четных числе = " + countEven(arr));
        Collection<String> collection = List.of("HighLoad", "High", "Load", "HighLoad");
        resultOfCollection(collection);
        resultOfCollection(Collections.emptyList());
        //3. Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
        // Необходимо отсортировать строки по возрастанию и добавить их в массив;
        Collection<String> collection1 = List.of("f10", "f15", "f2", "f4", "f4");
        Collection<String> collection2 = List.of("f50", "f45", "f2", "f4", "f4");
        String[] strings = collection1.stream().sorted().toArray(String[]::new);
        String[] strings2 = collection2.stream().sorted().toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings2));
        //задание 4
        int sum = students.stream().filter(x -> x.getGender() == Gender.MAN).
                reduce(0, (x, y) -> x + y.getAge(),
                        Integer::sum);
        int count = (int) students.stream().filter(x -> x.getGender() == Gender.MAN).count();
        System.out.println("Средний возраст студентов мужского пола = " + sum / count);
        System.out.println("Студенты кому грозит повестка в этом году:");
        students.stream().filter(x -> x.getGender() == Gender.MAN && (x.getAge() > 17 && x.getAge() < 28)).forEach(System.out::println);
        //задание 5
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            arrayList.add(input);
        }
        arrayList.stream().filter(x -> x.startsWith("f")).forEach(System.out::println);
    }

    //задание 1
    public static int countEven(ArrayList<Integer> arr) {
        return (int) arr.stream().filter(x -> x % 2 == 0).count();
    }

    //Задание 2
    public static void resultOfCollection(Collection<String> collection) {
        System.out.println("Объект High встречается в коллекции " + collection.stream().filter(x -> x.equals("High")).count() + " раз");
        System.out.println("На первом месте в коллекции находится " + collection.stream().findFirst().orElse("0"));
        System.out.println("Последний элемент в коллекции " + collection.stream().reduce((a, b) -> b).orElse("0"));
    }


    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

}
