package ru.geekbrains;

import java.util.*;

public class Lesson10 {

    public static void main(String[] args) {

        String[] array = {"Учеба", "Работа", "Дом", "Банан", "Учеба",
                "Отдых", "Метро", "Море", "Отдых", "Работа", "Сотрудник", "Учеба"};
        System.out.println("\nЗадача №1");
        uniqueValues(array);
        countWords(array);

        System.out.println("\nЗадача №2");

        PhoneBook personal = new PhoneBook();
        PhoneBook.Person p1 = new PhoneBook.Person("Иванов", "123-456");
        personal.add(p1);
        PhoneBook.Person p2 = new PhoneBook.Person("Сидоров", "147-258");
        personal.add(p2);
        PhoneBook.Person p3 = new PhoneBook.Person("Петров", "258-369");
        personal.add(p3);
        PhoneBook.Person p4 = new PhoneBook.Person("Федоров", "963-852");
        personal.add(p4);
        PhoneBook.Person p5 = new PhoneBook.Person("Песков", "456-789");
        personal.add(p5);
        PhoneBook.Person p6 = new PhoneBook.Person("Иванов", "654-321");
        personal.add(p6);
        PhoneBook.Person p7 = new PhoneBook.Person("Николаев", "852-741");
        personal.add(p7);
        PhoneBook.Person p8 = new PhoneBook.Person("Иванов", "987-321");
        personal.add(p8);
        personal.add(p1);

        personal.displayPhonebook();

        personal.get("Иванов");

    }

    /**
     * Создает набор с уникальными строковыми значениями из заданного массива
     * @param array для обработки уникальных значений
     */
    public static void uniqueValues(String[] array){
        Set<String> set = new HashSet<>(List.of(array));
        System.out.println("Входящий массив: " + Arrays.toString(array));
        System.out.printf("содержит %d слов.\n", array.length);
        System.out.printf("Из них массив содержит %d уникальных слов:\n", set.size());
        System.out.println(set + "\n");
    }

    /**
     * Вывод уникальных слов без повторения и подсчет
     * @param array для обработки строковых значений
     */
    public static void countWords(String[] array) {
        Set<String> uniqueArr = new HashSet<String>(List.of(array));
        for (String key : uniqueArr) {
            System.out.println(key + ": " + Collections.frequency(List.of(array), key));
        }
    }
}



