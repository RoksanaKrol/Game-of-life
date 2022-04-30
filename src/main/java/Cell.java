public class Cell {

    public static boolean willSurvive(Board board, int y, int x) {
        return (numberOfNeighbours(board, y, x) == 3 | numberOfNeighbours(board, y, x) == 2);
    }

    public static boolean willRevive(Board board, int y, int x) {
        return numberOfNeighbours(board, y, x) == 3;
    }

    public static int numberOfNeighbours(Board board, int y, int x) {
        int result = 0;
        int z = 0;
        int v = -1;
        int X = 0;
        int Y = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0: {
                        X = z;
                        Y = v;
                        break;
                    }
                    case 1: {
                        X = v;
                        Y = z;
                        if (z == 1) {
                            j++;
                        }
                        break;
                    }
                    case 2: {
                        X = v;
                        Y = v;
                        break;
                    }
                }
                try {
                   // System.out.println(  "Y: " + Y + "  X: " + X);
                    int yY = y + Y;
                    int xX = x + X;
                   // System.out.println(" cells["+yY+"]["+xX+"] "+board.cells[y + Y][x + X]+"\n");
                    if (board.cells[y + Y][x + X]) {
                        result += 1;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    result += curlAtEdges(board, Y, y, X, x);
                }
            }
            v += 2;

            if (v == 3) {
                v = -1;
                z = 1;
            }
        }
        return result;
    }
    public static int changeNum(int num, Board board, int yx){
        if (num == -1) {
            yx = board.size - 1;
        } else if (num == 1) {
            yx = 0;
        }
        return yx;
    }

    public static int curlAtEdges(Board board, int Y, int y, int X, int x) {
        int result = 0;
        int yY;
        int xX;

        if ((y + Y == board.size | y + Y == -1) && (x + X == board.size | x + X == -1)) {
            yY = changeNum(Y, board, y);
            xX = changeNum(X, board, x);
            //System.out.println(" cells["+yY+"]["+xX+"] "+board.cells[changeNum(Y, board, y)][changeNum(X, board, x)]+"\n");
            if (board.cells[changeNum(Y, board, y)][changeNum(X, board, x)]) {
                result = 1;
            }
        } else if (x + X == board.size | x + X == -1) {
            yY = y + Y;
            xX = changeNum(X, board, x);
          //  System.out.println(" cells["+yY+"]["+xX+"] "+board.cells[y + Y][changeNum(X, board, x)]+"\n");
            if (board.cells[y + Y][changeNum(X, board, x)]) {
                result = 1;
            }
        } else if (y + Y == board.size | y + Y == -1) {
            yY = changeNum(Y, board, y);
            xX = x + X;
          //  System.out.println(" cells["+yY+"]["+xX+"] "+board.cells[changeNum(Y, board, y)][x + X]+"\n");
            if (board.cells[changeNum(Y, board, y)][x + X]) {
                result = 1;
            }
        }
        return result;
    }
}
