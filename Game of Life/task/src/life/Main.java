package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size =scanner.nextInt();
        int seed = scanner.nextInt();
        Map map = new Map(size, seed);
        map.printMap();
    }
}
