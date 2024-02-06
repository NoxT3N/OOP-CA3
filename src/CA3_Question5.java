import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:Brindusa Dumitru
 *  Class Group:GD2a
 */

public class CA3_Question5
{

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String command;
        Queue<String> landings = new LinkedList<>();
        Queue<String> takeOffs = new LinkedList<>();

        System.out.println("Enter command: ");
        System.out.println("ex: takeOff <flight>, land <flight>, next");


        do{
             command = kb.nextLine();
            if(command.contains("takeOff")){
                takeOffs.add(command.substring(6));
            }
            else if(command.contains("land")){
                landings.add(command.substring(3));
            }
            else if(command.equals("next")){
                if(landings.isEmpty() && !takeOffs.isEmpty()){
                    System.out.println("Flight "+takeOffs.remove()+" takes off");
                }
                else if(!landings.isEmpty()){
                    System.out.println("Flight "+landings.remove()+" lands");
                }
                else{
                    System.out.println("No more flights scheduled");
                }
            }
        }while(!command.equals("quit"));

    }
}
