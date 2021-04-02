package JavaPractice;

import java.io.IOException;

public class ExceptionPractice {
    public static void throwIOException() throws IOException {
        throw new IOException();
    }

    public static void throwIOExceptionWithFinally() {
        try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("IOException has been caught");
        } finally {
            System.out.println("This message will be printed anyway. It's placed in the finally block");
        }
    }

    public static void main(String[] args) {
        try {
            throwIOException();
        } catch (IOException e) {
            System.out.println("IOException has been caught");
        }
        throwIOExceptionWithFinally();
    }
}
