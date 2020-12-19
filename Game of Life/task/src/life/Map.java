package life;

import java.util.Random;

class Map {
    final private boolean[][] MAP;

    public Map(int size, int seed) {
        Random random = new Random(seed);
        this.MAP = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.MAP[i][j] = random.nextBoolean();
            }
        }
    }

    void printMap() {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean[] row: MAP) {
            for (boolean cell: row) {
                if (cell) {
                    stringBuilder.append('O');
                } else {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder.toString());
    }
}
