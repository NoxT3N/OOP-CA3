import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Brindusa Dumitru
 *  Class Group: GD2a
 */
public class CA3_Question1
{
    public static void runSimulation()
    {
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        int choice;
        driveway.push(1);
        driveway.push(2);
        driveway.push(3);
        driveway.push(4);

        do{
            System.out.println("Cars in the driveway: "+ driveway.toString());
            System.out.println("Enter car to add/remove:\nEnter 0 to quit simulation");
            choice = keyboard.nextInt();

            if(choice > 0){
                driveway.push(choice);
                System.out.println("Driveway: "+driveway.toString());
            }
            else if(choice < 0) {
                choice = choice * -1;

                if (driveway.peek() == choice) {
                    driveway.pop();
                    street.push(choice);
                    System.out.println("Driveway: " + driveway.toString());
                    System.out.println("Street: " + street.toString());
                } else {
                    while (driveway.peek() != choice) {
                        street.push(driveway.peek());
                        driveway.pop();
                    }
                    System.out.println("Driveway: " + driveway.toString());
                    System.out.println("Street: " + street.toString());

                    driveway.pop();

                    while (!street.isEmpty()) {
                        driveway.push(street.peek());
                        street.pop();
                    }
                    System.out.println("Driveway: " + driveway.toString());
                    System.out.println("Street: " + street.toString());
                }
            }
        }while(choice !=0);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
