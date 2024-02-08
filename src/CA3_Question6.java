import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
/**
 *  Name: Brindusa Dumitru
 *  Class Group: GD2a
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Queue <Block> stocks = new LinkedList<>();
        String command;
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.print("Quantity:");
                int qty = in.nextInt();
                System.out.print("Price:");
                double price = in.nextDouble();
                stocks.add(new Block(qty,price));

            }
            else if (command.equals("sell")) {
                System.out.print("Quantity:");
                int qty = in.nextInt();

                System.out.print("Price:");
                double price = in.nextDouble();

                double profit = 0;
                if(!stocks.isEmpty()) {
                    while (qty > 0 && !stocks.isEmpty()) {
                        Block current = stocks.peek();

                        int toSell = Math.min(qty, current.qty);
                        double blockProfit = toSell * (price - current.price);

                        qty = qty - toSell;
                        profit = profit + blockProfit;

                        stocks.peek().qty = stocks.peek().qty - toSell;
                        if (stocks.peek().qty == 0) stocks.remove();
                    }

                    System.out.println("Profit: $" + profit);
                }
                else{
                    System.out.println("You have no shares to sell");
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

    public static class Block{
        public int qty;
        public double price;
        public Block(int qty, double price) {
            this.qty = qty;
            this.price = price;
        }
    }
}