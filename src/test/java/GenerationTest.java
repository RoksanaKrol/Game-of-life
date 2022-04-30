import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    @Test
    void nextGeneration() {
        Board board = new Board(5);
        board.cells[0][1] = true;
        board.cells[1][1] = true;
        board.cells[2][1] = true;

        String expected1 = "*  o  *  *  *  " + System.lineSeparator() +
                           "*  o  *  *  *  " + System.lineSeparator() +
                           "*  o  *  *  *  " + System.lineSeparator() +
                           "*  *  *  *  *  " + System.lineSeparator() +
                           "*  *  *  *  *  " + System.lineSeparator();

        assertEquals(expected1, board.print());

       board =  Generation.nextGeneration(board);

        String expected2 = "*  *  *  *  *  " + System.lineSeparator() +
                           "o  o  o  *  *  " + System.lineSeparator() +
                           "*  *  *  *  *  " + System.lineSeparator() +
                           "*  *  *  *  *  " + System.lineSeparator() +
                           "*  *  *  *  *  " + System.lineSeparator();

        assertEquals(expected2, board.print());
    }
}