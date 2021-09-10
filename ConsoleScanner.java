package group.tamrin;

import java.util.Scanner;

public class ConsoleScanner {
    private Scanner sc = new Scanner(System.in);
    public int getInt(){
        return sc.nextInt();
    }
    public String getString(){
        return sc.next();
    }
}
