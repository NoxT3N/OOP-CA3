import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:Brindusa Dumitru
 *  Class Group:GD2a
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST}

public class CA3_Question9
{
    public static int[][] maze = {
            {999,999,999,999,999,999,999,999},
            {999,0,0,0,0,0,0,999},
            {999,999,999,999,0,999,999,999},
            {0,0,0,0,0,0,0,999},
            {999,999,999,999,0,999,999,999},
            {999,0,0,0,0,0,999,999},
            {999,999,999,999,0,999,999,999},
            {999,999,999,999,999,999,999,999},
    }; //the maze from the textbook pdf
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("This is the maze:\n");
        display(maze);
        System.out.println("\nWhere would you like to start from?:");
        System.out.println("Row:");
        int x = kb.nextInt();
        System.out.println("Column:");
        int y = kb.nextInt();
        System.out.println("In which direction are you going?:");
        kb.nextLine();
        String dir = kb.nextLine();

        switch (dir.toLowerCase()){
            case "north"-> solve(x,y,DIRECTION.NORTH);
            case "south"-> solve(x,y,DIRECTION.SOUTH);
            case "east"-> solve(x,y,DIRECTION.EAST);
            case "west"-> solve(x,y,DIRECTION.WEST);
            default ->solve(x,y,DIRECTION.NORTH);
        }
        //solve(6,4,DIRECTION.NORTH);
        display(maze);
    }
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public static void solve(int x, int y, DIRECTION dir) {
        Stack<Pair>positions = new Stack<>();
        positions.push(new Pair(x,y));
        int topBoundary = maze.length;
        int count = 2;

        while(!positions.isEmpty()){
            Pair currentPos = positions.pop();
            x = currentPos.row;
            y = currentPos.col;

            if (maze[x][y] == 0 && (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1)) {
                maze[x][y] = count;
                System.out.println("Path found");
                return;
            }

            maze[x][y] = count;
            count++;

            switch (dir){
                case NORTH:
                    if(y+1 < topBoundary && maze[x][y+1] == 0) positions.push(new Pair(x,y+1)); //east
                    if(x+1 < topBoundary && maze[x+1][y] == 0) positions.push(new Pair(x+1,y)); //south
                    if(y-1 != -1 && maze[x][y-1] == 0) positions.push(new Pair( x,y-1)); //west
                    if(x-1 != -1 && maze[x-1][y] == 0 ) positions.push(new Pair(x-1,y)); //north
                    break;
                case EAST:
                    if(x+1 < topBoundary && maze[x+1][y] == 0) positions.push(new Pair(x+1,y)); //south
                    if(y-1 != -1 && maze[x][y-1] == 0) positions.push(new Pair( x,y-1)); //west
                    if(x-1 != -1 && maze[x-1][y] == 0 ) positions.push(new Pair(x-1,y)); //north
                    if(y+1 < topBoundary && maze[x][y+1] == 0) positions.push(new Pair(x,y+1)); //east
                    break;
                case SOUTH:
                    if(y-1 != -1 && maze[x][y-1] == 0) positions.push(new Pair( x,y-1)); //west
                    if(x-1 != -1 && maze[x-1][y] == 0 ) positions.push(new Pair(x-1,y)); //north
                    if(y+1 < topBoundary && maze[x][y+1] == 0) positions.push(new Pair(x,y+1)); //east
                    if(x+1 < topBoundary && maze[x+1][y] == 0) positions.push(new Pair(x+1,y)); //south
                    break;
                case WEST:
                    if(x-1 != -1 && maze[x-1][y] == 0 ) positions.push(new Pair(x-1,y)); //north
                    if(y+1 < topBoundary && maze[x][y+1] == 0) positions.push(new Pair(x,y+1)); //east
                    if(x+1 < topBoundary && maze[x+1][y] == 0) positions.push(new Pair(x+1,y)); //south
                    if(y-1 != -1 && maze[x][y-1] == 0) positions.push(new Pair( x,y-1)); //west
                    break;
            }

        }


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
