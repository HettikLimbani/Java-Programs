import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args){
        //creating a board and initilizing it with empty spaces
        char[][] board = new char[3][3];
        for (int row = 0; row<board.length ; row++){          
            for (int col = 0; col<board.length ; col++){
                board[row][col] = ' ';
            }
        }
        // In a 2D array the matrix.length function gives the output as row size.

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while(!gameOver){         // !-->Logical not  i.e. While my game is not over.
            System.out.println();
            printBoard(board);
            System.out.println("Player " + player + " Enter: "); // For taking the desired rows and col input.
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                board[row][col] = player; //Placing the element i.e. X or O.
                gameOver = haveWon (board,player);
                if(gameOver == true){
                    System.out.println("\nPlayer " + player + " has WON ");
                    printBoard(board); 
                } else {
                    //Swap players
                    player = (player == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move. Try again");
            }
        }


    }

    // Function 1
    public static boolean haveWon(char[][] board, char player){
        // Check the rows
        for (int row = 0; row<board.length ; row++){
           if( board[row][0] == player && board[row][1] == player && board[row][2] == player ) {
            return true;
           }
        }

        //Check for cols
        for (int col = 0; col<board.length ; col++){
            if( board[0][col] == player && board[1][col] == player && board[2][col] == player ) {
                return true;
            }
        }

        //Check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    // Function 2
    public static void printBoard(char[][] board){
        for (int row = 0; row<board.length ; row++){          
            for (int col = 0; col<board.length ; col++){
                System.out.print(board[row][col] + " |");
            }
            System.out.println();
        }
    }
}
