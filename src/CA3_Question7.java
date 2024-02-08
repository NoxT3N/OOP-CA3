import java.util.*;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question7
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<String, Queue<Block>> stocks = new TreeMap<>();
        String command;
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy")) {
                System.out.print("Company:");
                String company = in.next();

                System.out.print("Quantity:");
                int qty = in.nextInt();

                System.out.print("Price:");
                double price = in.nextDouble();

                Block block = new Block(qty,price);

                stocks.computeIfAbsent(company,k -> new LinkedList<>()).add(block);

//                if(!stocks.containsKey(company)){
//                    Queue<Block> blocks = new LinkedList<>();
//                    blocks.add(block);
//                    stocks.put(company,blocks);
//                }
//                else{
//                    stocks.get(company).add(block);
//                }
            }
            else if(command.equals("sell")) {

                System.out.print("Company:");
                String company = in.next();

                System.out.print("Quantity:");
                int qty = in.nextInt();

                System.out.print("Price:");
                double price = in.nextDouble();

                double profit = 0;

                System.out.println("Profit: $" + profit);

            }
        }while(!command.equalsIgnoreCase("quit"));
    }

    public static class Block {
        public int qty;
        public double price;

        public Block(int qty, double price) {
            this.qty = qty;
            this.price = price;
        }
    }
}
