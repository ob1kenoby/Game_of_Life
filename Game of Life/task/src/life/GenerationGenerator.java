package life;

public class GenerationGenerator {
    private int currentGeneration = 0;
    private Map currentMap;

    GenerationGenerator(Map map) {
        this.currentMap = map;
    }

    int getCurrentGeneration() {
        return currentGeneration;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    void nextGeneration() {
        Map nextMap = currentMap;
        for (int i = 0; i < nextMap.getSize(); i++) {
            for (int j = 0; j < nextMap.getSize(); j++) {
                if (currentMap.isCellAlive(i, j)) {
                    if (currentMap.isDyingCell(i, j)) {
                        nextMap.killCell(i, j);
                    }
                } else {
                    if (currentMap.isCellReborn(i, j)) {
                        nextMap.bornCell(i, j);
                    }
                }
            }
        }
        currentMap = nextMap;
        currentGeneration++;
    }
}
