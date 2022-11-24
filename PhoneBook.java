package ru.geekbrains;

import java.util.*;

public class PhoneBook {
    private final HashMap<String, List<String>> phoneBook = new HashMap<>();

    /**
     * Проверяет содержимое телефонной книги и добавляет или отклоняет записи
     * @param person объект из вложенного класса
     */
    public void add(Person person) {
        String name = person.getName();
        String phone = person.getPhoneNumber();
        if (!phoneBook.containsKey(name)) {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phone);
            phoneBook.put(name, phoneList);
            System.out.printf("Была создана новая запись: %s %s.\n", name, phone);
        } else if (phoneBook.containsKey(name) && phoneBook.get(name).contains(phone)) {
            System.out.printf("%s с номером телефона %s уже существует.\n", name, phone);
        } else {
            phoneBook.get(name).add(phone);
            System.out.printf("Новый номер телефона %s был успешно добавлен к существующей записи %s.\n", phone, name);
        }
    }

    /**
     * Проверяет записи телефонной книги на наличие указанного имени и выводит телефонные номера
     * @param name для поиска
     */
    public void get(String name) {
        List<String> phoneNumbers;
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (Objects.equals(entry.getKey(), name)) {
                phoneNumbers = entry.getValue();
                System.out.printf("%s имеет % d номер(а) телефона(ов):\n", name, phoneNumbers.size());
                System.out.println(phoneNumbers);
                return;
            }
        }
        System.out.printf("Нет записей с именем %s.\n", name);
    }

    /**
     * Отображает телефонную книгу с предустановленным форматированием
     */
    public void displayPhonebook() {
        System.out.println("\n***Моя телефонная книга***");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println();
    }

    /**
     * Вложенный класс для создания пользователя с именем и номером телефона
     */
    static class Person {

        private final String name;
        private String phoneNumber;

        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}

