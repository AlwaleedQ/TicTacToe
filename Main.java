import java.io.IOException;
import java.util.*;

public class Main {


    enum Player{
        medo , waleed , nothing; 
    }



    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner scanner = new Scanner(System.in) ;

        

        
       int input ;
        

       char[][] table = {
        { ' ', '|', ' ', '|', ' ' }, 
        { '-', '-', '-', '-', '-' }, 
        { ' ', '|', ' ', '|', ' ' },
        { '-', '-', '-', '-', '-' },
        { ' ', '|', ' ', '|', ' ' }, };
        
        
        int stopGame = 0 ;

        printTable(1, Player.nothing, table, stopGame);
        System.out.println("\n\n");


        do{
            
            System.out.print("Medo please play (-1 to Quit) : ");
             input = scanner.nextInt() ;
             new ProcessBuilder("cmd" , "/c" , "cls").inheritIO().start().waitFor();
            printTable(input, Player.medo , table , stopGame);
            if(stopGame == -1) break;
            System.out.println("\n\n");
            System.out.print("Waleed please play (-1 to Quit) : ");
             input = scanner.nextInt() ;
             new ProcessBuilder("cmd" , "/c" , "cls").inheritIO().start().waitFor();
            printTable(input, Player.waleed , table , stopGame);
            if(stopGame == -1) break;
            System.out.println("\n\n");
            


        }  while(input != -1);





        scanner.close();

    } // end of main method

    static String reverseString(String str) {

        String ans = "";

        for (int i = str.length() - 1; i >= 0; i--) {

            ans += str.charAt(i);
        }
        return ans;
    }

    static boolean isTheSame(String str) {

        return str.equals(reverseString(str));

    }

    static void printTable(int index , Player p , char[][] table, int stopGame) {
        
        char symbol = ' ' ;

        if(p == Player.medo){
            symbol = 'X' ;
        }
        else if(Player.nothing == p){
            symbol= ' ' ; 
        }
        else{
            symbol = 'O' ;
        }

        


            boolean rightIndex = true;


            switch(index){
                case 1: 
                    table[0][0] = symbol ;
                    break ;
                case 2 :
                    table[0][2] = symbol ;
                    break ;
                case 3 : 
                    table[0][4] = symbol ; 
                    break;
                case 4 :
                    table[2][0] = symbol ;
                    break;
                case 5 : 
                    table [2][2] = symbol ;
                    break;
                case 6:
                    table[2][4] = symbol ;
                    break;
                case 7:
                    table[4][0] = symbol ;
                    break ;
                case 8: 
                    table[4][2] = symbol ;
                    break ; 
                case 9: 
                    table[4][4] = symbol ;
                    break ;
                
                default: 
                    rightIndex = false ; 


            }
            int counter = 0 ;
            if(rightIndex == true){
                for (int i = 0; i < table.length; i++) {
                    for (int j = 0; j < table[i].length; j++) {
                        if(table[i][j] == 'X' || table[i][j] == 'O'){
                            counter++ ;
                        }
                        if(counter == 10){
                            stopGame = -1 ;
                        }
                        System.out.print(table[i][j] + " ");
                    }
                    System.out.println();
                }
                
            }   else{
                System.out.println("kos wajhak");
            }

      // TODO: versus bot, stopping game.

    }

} // end of main class