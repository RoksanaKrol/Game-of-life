import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int generations = 0;
        String choise = "";
        while (true) {

            generations = 0;
            System.out.println("--------------Game of life--------------");
            System.out.println("Enter '1' to see example");
            System.out.println("Enter '2' to play");
            System.out.println("Enter 'o' to finish");

            choise = scanner.nextLine();
            Board board = null;
            if (choise.equals("1")) {
                board = new Board(10);
                board.cells[5][5] = true;
                board.cells[4][4] = true;
                board.cells[5][3] = true;
                board.cells[5][4] = true;
            } else if (choise.equals("2")) {

                System.out.println("Board size: ");
                int boardSize = 0;
                while (!(boardSize > 2)) {
                    try {
                        boardSize = Integer.parseInt(scanner.nextLine());
                        board = new Board(boardSize);
                    } catch (Exception e) {
                        System.out.println("Try again (Use number greater than 2)");
                    }
                }
                while (!scanner.nextLine().equals("-")) {
                    System.out.println("Enter position of living cells or '-' to start");

                    int y = 0;
                    String inputY = "";
                    while (true) {
                        System.out.print("y: ");
                        inputY = scanner.nextLine();
                        if (inputY.equals("-")) {
                            break;
                        }
                        try {
                            y = Integer.parseInt(inputY);
                            if (y > boardSize - 1) {
                                y = boardSize - 1;
                            }
                            if (y < 0) {
                                y = 0;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Try again (Use number)");
                        }
                    }
                    if (inputY.equals("-")) {
                        break;
                    }

                    int x = 0;
                    String inputX = "";
                    while(true) {
                        System.out.print("x: ");
                        inputX = scanner.nextLine();
                        if (inputX.equals("-")) {
                            break;
                        }
                        try {
                            x = Integer.parseInt(inputX);
                            if (x > boardSize - 1) {
                                x = boardSize - 1;
                            }
                            if (x < 0) {
                                x = 0;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Try again (Use number)");
                        }
                    }
                    if (inputX.equals("-")) {
                        break;
                    }

                    board.cells[y][x] = true;
                }
            } else {
                break;
            }

            System.out.println("------Generation: " + generations + " ------");
            System.out.println(board.print());
            generations++;

            while (!scanner.nextLine().equals("o")) {
                System.out.println("Press 'enter' to continue\n Press 'o' and 'enter' to stop");
                board = Generation.nextGeneration(board);
                System.out.println("------Generation: " + generations + " ------");
                System.out.println(board.print());
                generations++;
            }
        }
    }
}
