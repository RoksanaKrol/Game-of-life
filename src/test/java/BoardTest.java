import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void printBoard() {
        Board board = new Board(4);
        board.cells[1][1] = true;
        board.cells[2][1] = true;
        board.cells[3][1] = true;
        String expected =  "*  *  *  *  " + System.lineSeparator() +
                           "*  o  *  *  " + System.lineSeparator() +
                           "*  o  *  *  " + System.lineSeparator() +
                           "*  o  *  *  " + System.lineSeparator();
        assertEquals(expected, board.print());
    }

}