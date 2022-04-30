public class Board {
    boolean[][] cells;
    int size;

    public Board(int size) {
        cells = new boolean[size][size];
        this.size = size;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (boolean[] i  : cells) {
            for (boolean j : i){
                if (j){
                    result.append("o");
                } else {
                    result.append("*");
                }
                result.append("  ");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

}
