package com.goit11.spring_demo_example.entity.note;

public class NoteIdException extends Exception{
    public NoteIdException() {
    }

    public NoteIdException(String message) {
        super(message);
    }

    public NoteIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteIdException(Throwable cause) {
        super(cause);
    }

    public NoteIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
