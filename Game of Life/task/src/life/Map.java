package life;

import java.util.Random;

class Map {
    final private boolean[][] MAP;
    final private int SIZE;

    public Map(int size, int seed) {
        Random random = new Random(seed);
        this.SIZE = size;
        this.MAP = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.MAP[i][j] = random.nextBoolean();
            }
        }
    }

    int getSize() {
        return SIZE;
    }

    private int getLiveNeighbors(int x, int y) {
        int liveNeighbors = 0;
        int[][][] neighbors = new int[3][3][2];
        for (int i = 0; i < neighbors.length; i++) {
            neighbors[1][i][0] = x;
            if (x == 0) {
                neighbors[0][i][0] = SIZE - 1;
            } else {
                neighbors[0][i][0] = x - 1;
            }
            if (x == SIZE - 1) {
                neighbors[2][i][0] = 0;
            } else {
                neighbors[2][i][0] = x + 1;
            }

            neighbors[i][1][1] = y;
            if (y == 0) {
                neighbors[i][0][1] = SIZE - 1;
            } else {
                neighbors[i][0][1] = y - 1;
            }
            if (y == SIZE - 1) {
                neighbors[i][2][1] = 0;
            } else {
                neighbors[i][2][1] = y + 1;
            }
        }
        for (int[][] row: neighbors) {
            for (int[] cell: row) {
                if (cell[0] != x && cell[1] != y && isCellAlive(cell)) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }

    boolean isCellAlive(int... coordinates) {
        return MAP[coordinates[0]][coordinates[1]];
    }

    boolean isDyingCell(int x, int y) {
        int neighbors = getLiveNeighbors(x, y);
        return !(neighbors == 2 || neighbors == 3);
    }

    boolean isCellReborn(int x, int y) {
        return getLiveNeighbors(x, y) == 3;
    }

    void killCell(int x, int y) {
        MAP[x][y] = false;
    }

    void bornCell(int x, int y) {
        MAP[x][y] = true;
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
