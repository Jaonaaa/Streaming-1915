package src.main;

import src.Infrastructure.Window;

public class RunClient {

    public static void main(String[] args) {

        try {
            new Window();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}