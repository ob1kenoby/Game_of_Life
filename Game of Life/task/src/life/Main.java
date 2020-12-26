package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size =scanner.nextInt();
        int seed = scanner.nextInt();
        int generation = scanner.nextInt();
        Map map = new Map(size, seed);
        GenerationGenerator game = new GenerationGenerator(map);
        while (game.getCurrentGeneration() < generation) {
            game.nextGeneration();
            System.out.println(game.getCurrentGeneration());
            game.getCurrentMap().printMap();
        }
        game.getCurrentMap().printMap();
    }
}
