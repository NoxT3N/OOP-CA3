import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:Brindusa Dumitru
 *  Class Group: GD2a
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(r,c));
        int count = 1;

        while(!stack.isEmpty()){
            Pair current = stack.pop(); //changes the current cell that needs to be filled
            r = current.row;
            c = current.col;

            if(arr[r][c] == 0 ){
                arr[r][c] = count; //if cell is 0 then it needs to be filled with the appropriate number

                //gets the coordinate of the neighbouring cells
                if(r-1 != -1 && arr[r-1][c] == 0 ) stack.push(new Pair(r-1,c)); //north
                if(c+1 < 10 && arr[r][c+1] == 0) stack.push(new Pair(r,c+1)); //east
                if(r+1 < 10 && arr[r+1][c] == 0) stack.push(new Pair(r+1,c)); //south
                if(c-1 != -1 && arr[r][c-1] == 0) stack.push(new Pair( r,c-1)); //west


                count++;
            }
        }



    }

    public static void start() {
        int[][] arr = floodFillStart();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter row: ");
        int r = keyboard.nextInt();
        System.out.println("Enter column");
        int c = keyboard.nextInt();

        fill(r,c,arr);

       display(arr);
    }
    public static void main(String[] args) {

        start();

    }

    public static class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
