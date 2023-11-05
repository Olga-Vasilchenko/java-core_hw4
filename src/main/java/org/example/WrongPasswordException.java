package org.example;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("Используется недопустимые для пароля символы");
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
