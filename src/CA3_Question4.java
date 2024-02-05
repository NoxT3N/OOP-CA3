import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Brindusa Dumitru
 *  Class Group: GD2a
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(filename));
        Stack<String> tags = new Stack<>();
        boolean properNest = false;

        while(in.hasNext()){
            String tag = in.next();
            if(!tag.contains("/")){
                tags.push(tag);
            }
            else if(tag.substring(2).equals(tags.peek().substring(1))){
                properNest = true;
                tags.pop();
            }
            else{
                properNest = false;
            }
        }
        return properNest;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
