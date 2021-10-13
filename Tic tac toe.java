import java.util.Scanner;

class Main {
    public static boolean winner(String line, char xo) {
        boolean Xwin = false;
        boolean Owin = false;
        // horizontal lines
        for (int i = 0; i < 3; i++) {
            if (line.charAt(3 * i) == line.charAt((3 * i) + 1)) {
                if(line.charAt(3 * i) == line.charAt((3 * i) + 2)) {
                    if (line.charAt(3 * i) == 'X') {
                        Xwin = true;
                    } else if (line.charAt(3 * i) == 'O'){
                        Owin = true;
                    }
                }
            }
        }

        // vertical lines
        for (int i = 0; i < 3; i++) {
            if (line.charAt(i) == line.charAt(3 + i)) {
                if(line.charAt(i) == line.charAt(6 + i)) {
                    if (line.charAt(i) == 'X') {
                        Xwin = true;
                    } else if (line.charAt(i) == 'O'){
                        Owin = true;
                    }
                }
            }
        }

        // diagonal lines
        if (line.charAt(0) == line.charAt(4)) {
            if (line.charAt(0) == line.charAt(8)) {
                if (line.charAt(0) == 'X') {
                    Xwin = true;
                } else if (line.charAt(0) == 'O'){
                    Owin = true;
                }
            }
        }

        if (line.charAt(6) == line.charAt(4)) {
            if (line.charAt(6) == line.charAt(2)) {
                if (line.charAt(6) == 'X') {
                    Xwin = true;
                } else if (line.charAt(0) == 'O'){
                    Owin = true;
                }
            }
        }

        if (xo == 'X') {
            return Xwin;
        }
        return Owin;
    }

    public static String logic(String line) {
        boolean Xwin = winner(line, 'X');
        boolean Owin = winner(line, 'O');
        int Xcount = 0;
        int Ocount = 0;

        if (Xwin && Owin) {
            return "Impossible";
        }

        if (Xwin) {
            return "X wins";
        }
        if (Owin) {
            return "O wins";
        }

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'X') {
                Xcount++;
            } else if (line.charAt(i) == 'O') {
                Ocount++;
            }
        }

        if (Xcount - Ocount > 1 || Ocount - Xcount > 1) {
            return "Impossible";
        }

        if (Xcount + Ocount == 9) {
            if (!Xwin && !Owin) {
                return "Draw";
            }
        }
        return "Game not finished";
    }

    public static String addMove(String line, char xo) {
        Scanner scanner = new Scanner(System.in);
        int index; // location of the empty cell
        boolean bool = true; // keeps the loop going
        String coords; // analyzing the input as one line
        int[] n = new int[2]; // taking the numbers for ease
        // of use in other functions
        while (bool) {
            System.out.print("Enter the coordinates: ");
            coords = scanner.nextLine();
            if (coords.matches("\\d \\d")) { // two numbers
                if (coords.matches("[1-3] [1-3]")) { // two numbers between 1 & 3
                    n[0] = Integer.parseInt(coords.substring(0, 1)); // moving those
                    n[1] = Integer.parseInt(coords.substring(2, 3)); // numbers to the array
                    switch (line.charAt((n[0] - 1) * 3 + (n[1] - 1))) {
                        case ' ':
                        case '_':
                            index = (n[0] - 1) * 3 + (n[1] - 1); // first half is the row, second half is the column
                            line = line.substring(0, index) + xo + line.substring(index + 1);
                            bool = false;
                        default:
                            if (!bool) {
                                break;
                            }
                            System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        return line;
    }

    public static void print(String line) {
        System.out.println("---------");
        System.out.println("| " + line.charAt(0) + " " + line.charAt(1) + " " + line.charAt(2) + " |");
        System.out.println("| " + line.charAt(3) + " " + line.charAt(4) + " " + line.charAt(5) + " |");
        System.out.println("| " + line.charAt(6) + " " + line.charAt(7) + " " + line.charAt(8) + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cells = "_________";
        char xo = 'X';
        boolean win = false;
        while (!win) {
            print(cells);
            cells = addMove(cells, xo);
            switch (logic(cells)) {
                case "Game not finished":
                    if (xo == 'X') {
                        xo = 'O';
                    } else {
                        xo = 'X';
                    }
                    break;
                default:
                    print(cells);
                    win = true;
                    System.out.print(logic(cells));
                    break;
            }
        }
    }
}