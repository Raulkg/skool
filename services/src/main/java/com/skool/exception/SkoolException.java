package com.skool.exception;

public class SkoolException extends Exception
{
    public SkoolException(String message)
    {
        super(message);
    }

    public SkoolException(Throwable cause) {
        super(cause);
    }

    public SkoolException(String string ,Throwable cause) {
        super(string,cause);
    }
}