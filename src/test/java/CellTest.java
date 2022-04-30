import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void numberOfNeighboursAll() {
        Board board = new Board(4);
        board.cells[0][0] = true;
        board.cells[0][1] = true;
        board.cells[0][2] = true;
        board.cells[1][0] = true;
        board.cells[1][1] = true;
        board.cells[1][2] = true;
        board.cells[2][0] = true;
        board.cells[2][1] = true;
        board.cells[2][2] = true;
        assertEquals(8, Cell.numberOfNeighbours(board, 1,1));
    }

    @Test
    void numberOfNeighboursNone(){
        Board board = new Board(4);
        assertEquals(0,Cell.numberOfNeighbours(board, 1,1));
    }

    @Test
    void numberOfNeighboursRandom(){
        Board board = new Board(4);
        board.cells[0][2] = true;
        board.cells[1][2] = true;
        board.cells[2][2] = true;
        board.cells[0][1] = true;
        board.cells[1][1] = true;
        assertEquals(4, Cell.numberOfNeighbours(board,1,1));
    }

    @Test
    void numberOfNeighboursRandom2(){
        Board board = new Board(4);
        board.cells[0][2] = true;
        board.cells[1][2] = true;
        board.cells[2][2] = true;
        board.cells[0][1] = true;
        board.cells[1][1] = true;
        board.cells[1][0] = true;
        board.cells[2][0] = true;
        board.cells[0][0] = true;
        assertEquals(7, Cell.numberOfNeighbours(board,1,1));
    }

    @Test
    void numberOfNeighboursOnTheOtherSideOfBoard() {
        Board board = new Board(5);
        board.cells[2][0] = true;
        board.cells[1][4] = true;
        board.cells[3][4] = true;

        assertEquals(2, Cell.numberOfNeighbours(board, 2,0));
    }

    @Test
    void changeNum(){
        Board board = new Board(3);
        assertEquals(0, Cell.changeNum(1, board, 3));
        assertEquals(2,Cell.changeNum(-1, board, -1));
    }

    @Test
    void curlAtEdges2plus() {
        Board board = new Board(5);
        board.cells[0][0] = true;
        assertEquals(1, Cell.curlAtEdges(board, 1, 4, 1, 4));
    }

    @Test
    void curlAtEdges2minus() {
        Board board = new Board(5);
        board.cells[4][4] = true;
        assertEquals(1, Cell.curlAtEdges(board, -1, 0, -1, 0));
    }

    @Test
    void curlAtEdgesXplus() {
        Board board = new Board(5);
        board.cells[2][0] = true;
        assertEquals(1, Cell.curlAtEdges(board, -1, 3, 1, 4));
    }

    @Test
    void curlAtEdges() {
        Board board = new Board(5);
        board.cells[1][4] = true;
        assertEquals(1, Cell.curlAtEdges(board, 0, 1, -1, 0));
    }

    @Test
    void curlAtEdges2() {
        Board board = new Board(5);
        board.cells[3][4] = true;
        assertEquals(1, Cell.curlAtEdges(board, 0, 3, -1, 0));
    }

}