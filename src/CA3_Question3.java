import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  Name: Brindusa Dumitru
 *  Class Group: GD2a
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        in.useDelimiter("[^A-Za-z0-9_]+");
        Scanner getLine = new Scanner(new File(fileName));

        Map<String, ArrayList<String>> identifiers = new HashMap<>();
        int lineNum = 1;

        while(in.hasNext()){
            String identifier = in.next();
            String line = "Line "+ lineNum+": "+ in.nextLine();

            if(!identifiers.containsKey(identifier)){ //if identifier does not exist add it to the map
                ArrayList<String> lines = new ArrayList<>();
                lines.add(line);

                identifiers.put(identifier,lines);
            }
            else{//else  add line in the lines arraylist
                identifiers.get(identifier).add(line);
            }
            lineNum++;
        }

        for (Map.Entry<String, ArrayList<String>> entry : identifiers.entrySet()) {
            System.out.println("\nIdentifier: " + entry.getKey());
            for (String location : entry.getValue()) {
                System.out.println(location);
            }
        }
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}