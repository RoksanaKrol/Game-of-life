public class Generation {

    public static Board nextGeneration (Board board) {
        Board newBoard = new Board(board.size);
        for (int i = 0; i < board.size;) {
            for (int j = 0; j < board.size;) {
                if (board.cells[i][j]) {
                    //System.out.println((" cells["+i+"]["+j+"] "+board.cells[i][j]+Cell.willSurvive(board, i, j)+Cell.numberOfNeighbours(board, i, j)+"\n"));
                    newBoard.cells[i][j] = Cell.willSurvive(board, i, j);
                } else {
                    //System.out.println((" cells["+i+"]["+j+"] "+board.cells[i][j]+Cell.willRevive(board, i, j)+Cell.numberOfNeighbours(board, i, j)+"\n"));
                    newBoard.cells[i][j] = Cell.willRevive(board, i, j);
                }
                j++;
            }
            i++;
        }
        return newBoard;
    }
}