import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class SnakeGameTester {

    @Test
    //Normal Test Case
    public void testFindTailExhaustive1() {
        boolean I =true;//snake body
        boolean O =false;//empty space
        boolean [][] game= {//make up board
                {O,O,O,O,O},
                {O,I,I,I,O},
                {O,I,O,O,O},
                {O,I,I,I,O},
        };

        SnakeGame Snake = new SnakeGame(game,1,3);//Where the head is located
        int [] result = Snake.findTailExhaustive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;//x position of the tail
        returnVal[1] = 3;//y position of the tail
        returnVal[2] = 6;//length of snake
        assertArrayEquals(returnVal,result);
    }
    @Test
    //if one of the parts of the snake was separated
    public void testFindTailExhaustive2() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,O,O,I,O},
                {O,O,O,O,O},
                {O,O,O,O,O},
                {O,I,I,I,O},
        };

        SnakeGame Snake = new SnakeGame(game,1,1);
        int [] result = Snake.findTailExhaustive();
        int [] returnVal = new int [3];
        returnVal[0] = 1;
        returnVal[1] = 1;
        returnVal[2] = 3;
        assertArrayEquals(returnVal,result);
    }
    @Test
    //If the snake has multiple heads and tails
    public void testFindTailExhaustive3() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,O,O,O,O},
                {O,I,I,I,O},
                {O,O,I,O,O},
                {O,I,I,I,O},
        };

        SnakeGame Snake = new SnakeGame(game,1,3);
        int [] result = Snake.findTailExhaustive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;
        returnVal[1] = 3;
        returnVal[2] = 7;
        assertArrayEquals(returnVal,result);
    }
    @Test
    //if the part of the snake was separated by a diagonal
    public void testFindTailExhaustive4() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,O,O,O,I},
                {O,I,I,I,O},
                {O,I,O,O,O},
                {O,I,I,I,O},
        };
        SnakeGame Snake = new SnakeGame(game,0,4);
        int [] result = Snake.findTailExhaustive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;
        returnVal[1] = 3;
        returnVal[2] = 8;
        assertArrayEquals(returnVal,result);
    }
    @Test
    //if there is no snake at all on the board
    public void testFindTailExhaustive5() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,O,O,O,O},
                {O,O,O,O,O},
                {O,O,O,O,O},
                {O,O,O,O,O},
        };

        SnakeGame Snake = new SnakeGame(game,0,0);
        int [] result = Snake.findTailExhaustive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;
        returnVal[1] = 4;
        returnVal[2] = 20;
        assertArrayEquals(returnVal,result);
    }
    @Test
    public void testFindTailRecursive1() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,O,O,O,O},
                {O,I,I,I,O},
                {O,I,O,O,O},
                {O,I,I,I,O},
        };

        SnakeGame Snake = new SnakeGame(game,1,3);
        int [] result = Snake.findTailRecursive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;
        returnVal[1] = 3;
        returnVal[2] = 6;
        assertArrayEquals(returnVal,result);
    }
    @Test
    public void testFindTailRecursive2() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,I,O,O,O},
                {O,I,O,O,O},
                {O,I,O,O,O},
                {O,O,O,O,O},
        };

        SnakeGame Snake = new SnakeGame(game,0,1);
        int [] result = Snake.findTailRecursive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;
        returnVal[1] = 1;
        returnVal[2] = 4;
        assertArrayEquals(returnVal,result);
    }
    @Test
    public void testFindTailRecursive3() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {O,O,O,O,O},
                {O,O,O,O,O},
                {O,O,O,O,O},
                {O,O,O,O,O},
        };

        SnakeGame Snake = new SnakeGame(game,1,3);
        int [] result = Snake.findTailRecursive();
        int [] returnVal = new int [3];
        returnVal[0] = 3;
        returnVal[1] = 3;
        returnVal[2] = 6;
        assertArrayEquals(returnVal,result);
    }
    @Test
    public void testFindTailRecursive4() {
        boolean I = true;
        boolean O = false;
        boolean [][] game= {
                {I,I,I,I,I},
                {I,O,O,O,O},
                {I,O,O,O,O},
                {I,I,I,I,I},
        };

        SnakeGame Snake = new SnakeGame(game, 3,4);
        int [] result = Snake.findTailRecursive();
        int [] returnVal = new int [3];
        returnVal[0] = 0;
        returnVal[1] = 4;
        returnVal[2] = 12;
        assertArrayEquals(returnVal,result);
    }
    @Test
    public void testFindTailRecursive5() {
        boolean I = true;
        boolean O = false;
        boolean[][] game = {
                {O, O, O, O, O},
                {O, O, O, O, O},
                {O, I, O, O, O},
                {O, O, O, O, O}
            };

        SnakeGame Snake = new SnakeGame(game, 2, 1);
        int[] result = Snake.findTailRecursive();
        int[] returnVal = new int[3];
        returnVal[0] = 2;
        returnVal[1] = 1;
        returnVal[2] = 1;
        assertArrayEquals(returnVal, result);
      }
    }
