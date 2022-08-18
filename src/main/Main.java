package main;

import util.InputUtil;
import util.MenuUtil;
import util.StudentUtil;


public class Main {
    public static void main(String[] args) {
        Config.initialize();
        int menu = 0;
        while (true) {
            menu = InputUtil.requireNumber("What do you want to do?"
                    + "\n1.Register Student"
                    + "\n2.Show all students"
                    + "\n3.Find student"
                    + "\n4.Update students"
                    + "\n5.Exit");
            MenuUtil.processMenu(menu);
        }
    }
}

