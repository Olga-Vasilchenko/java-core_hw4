package org.example;
// 1. Задача: Проверка логина и пароля
//        1 - Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//        2 - Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
//        3 - Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//        4 - WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
//        5 - В основном классе программы необходимо по-разному обработать исключения.
//        6 - Метод возвращает true, если значения верны или false в другом случае.

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        try {
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();
        try {
            checkPassword(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод проверки логина
    public static void checkLogin(String login) throws WrongLoginException {
        if(login.length() >= 20) {
            throw new WrongLoginException("Ошибка! Превышена длина логина.");
        }
        CharacterIterator it = new StringCharacterIterator(login);
        while (it.current() != CharacterIterator.DONE)
        {
            if(it.current() < '0' | it.current() > '9' & it.current() < 'A' |
            it.current() > 'Z' & it.current() < 'a' & it.current() != '_' | it.current() > 'z') {
                throw new WrongLoginException();
            }
            it.next();
        }
    }

    // Метод проверки пароля
    public static void checkPassword(String password, String confirmPassword)
            throws WrongPasswordException {
        if(!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка! Пароли не одинаковы.");
        }
        if(password.length() >= 20) {
            throw new WrongPasswordException("Ошибка! Превышена длина логина.");
        }
        char[] character = password.toCharArray();
        for (char ch : character) {
            if(ch < '0' | ch > '9' & ch < 'A' | ch > 'Z' & ch < 'a' & ch != '_' | ch > 'z') {
                throw new WrongPasswordException();
            }
        }
    }
}