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
            Pair current = stack.pop();
            r = current.row;
            c = current.col;

            if(arr[r][c] == 0 ){
                arr[r][c] = count;
                if(arr[r-1][c] == 0 && r-1 != -1) stack.push(new Pair(r-1,c)); //north
                if(arr[r+1][c] == 0 && r+1 < 10) stack.push(new Pair(r+1,c)); //south
                if(arr[r][c-1] == 0 && c-1 != -1) stack.push(new Pair( r,c-1)); //west
                if(arr[r][c+1] == 0 && c+1 < 10) stack.push(new Pair(r,c+1)); //east

                count++;
                display(arr);
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
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
