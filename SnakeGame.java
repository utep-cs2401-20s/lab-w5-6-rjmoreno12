public class SnakeGame {
    private boolean[][] gameBoard;
    private int location[];
    private static int recursiveCounter;
    private static int exhaustiveCounter;

    public SnakeGame() {
        this.gameBoard = new boolean[1][1];
        this.recursiveCounter = 0;
        this.exhaustiveCounter = 0;
    }

    public SnakeGame(boolean[][] gameBoard, int x, int y) {
        this.gameBoard = gameBoard;
        location[0] = x;
        location[1] = y;
        this.exhaustiveCounter = 0;
        this.recursiveCounter = 0;

    }

    private void resetCounters() {
        this.exhaustiveCounter = 0;
        this.recursiveCounter = 0;
    }

    static int getRecursiveChecks() {
        return exhaustiveCounter;
    }

    static int getExhaustiveChecks() {
        return recursiveCounter;
    }

    public int[] findTailExhaustive() {
        exhaustiveCounter++;
        int neighborCount = 0;
        int[] finalVal = { 0, 0, 0 };
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                neighborCount = 0;
                if (gameBoard[i][j]) {
                    finalVal[2]++;
                    if ((i - 1) >= 0 && (j - 1) >= 0 && gameBoard[i - 1][j - 1]) {
                        neighborCount++;
                    }
                    if ((i - 1) >= 0 && gameBoard[i - 1][j]) {
                        neighborCount++;
                    }
                    if ((j - 1) >= 0 && gameBoard[i][j - 1]) {
                        neighborCount++;
                    }
                    if ((i + 1) < gameBoard.length && (j + 1) < gameBoard.length && gameBoard[i + 1][j + 1]) {
                        neighborCount++;
                    }
                    if ((i + 1) < gameBoard.length && gameBoard[i + 1][j]) {
                        neighborCount++;
                    }
                    if ((j + 1) < gameBoard.length && gameBoard[i][j + 1]) {
                        neighborCount++;
                    }
                    if ((i - 1) >= 0 && (j + 1) < gameBoard.length && gameBoard[i - 1][j + 1]) {
                        neighborCount++;
                    }
                    if ((i + 1) < gameBoard.length && (j - 1) >= 0 && gameBoard[i + 1][j - 1]) {
                        neighborCount++;
                    }
                }
                if ((neighborCount == 1) && (!(location[0] == i) && (location[1] == j))) {
                    finalVal[0] = i;
                    finalVal[1] = j;
                }
            }
        }
        return finalVal;
    }

    public int[] findTailRecursive() {
        recursiveCounter++;
        int[] neighbor = new int[2];
        int[] finalArr = { 0, 0, 0 };
        if ((location[0] + 1) < gameBoard.length && gameBoard[location[0] + 1][location[1]]) {
            neighbor[0] = location[0] + 1;
            neighbor[1] = location[1];
        }
        if ((location[1] + 1) < gameBoard.length && gameBoard[location[0]][location[1] + 1]) {
            neighbor[0] = location[0];
            neighbor[1] = location[1] + 1;
        }
        if ((location[0] - 1) >= 0 && gameBoard[location[0] - 1][location[1]]) {
            neighbor[0] = location[0] - 1;
            neighbor[1] = location[1];
        }
        if ((location[1] - 1) >= 0 && gameBoard[location[0]][location[1] - 1]) {
            neighbor[0] = location[0];
            neighbor[1] = location[1] - 1;
        }
        int[] tail = findTailRecursive(neighbor, location);
        tail[2]++;
        return finalArr;
    }

    private int[] findTailRecursive(int[] current, int[] previous) {
        recursiveCounter++;
        int[] neighbor = new int[2];
        int[] finalVal = { 0, 0, 0 };
        if ((current[0] + 1) < gameBoard.length && gameBoard[current[0] + 1][current[1]]
                && (!(current[0] + 1 == previous[0] && current[1] == previous[1]))) {
            neighbor[0] = current[0] + 1;
            neighbor[1] = current[1];
        }
        if ((current[1] + 1) < gameBoard.length && gameBoard[current[0]][current[1] + 1]
                && (!(current[0] == previous[0] && current[1] + 1 == previous[1]))) {
            neighbor[0] = current[0];
            neighbor[1] = current[1] + 1;
        }
        if ((current[0] - 1) >= 0 && gameBoard[current[0] - 1][current[1]]
                && (!(current[0] - 1 == previous[0] && current[1] == previous[1]))) {
            neighbor[0] = current[0] - 1;
            neighbor[1] = current[1];
        }
        if ((current[1] - 1) >= 0 && gameBoard[current[0]][current[1] - 1]
                && (!(current[0] == previous[0] && current[1] - 1 == previous[1]))) {
            neighbor[0] = current[0];
            neighbor[1] = current[1] - 1;
        }
        int[] tail = findTailRecursive(neighbor, current);
        tail[2]++;
        return finalVal;
    }
}