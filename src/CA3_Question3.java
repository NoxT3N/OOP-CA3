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

        Map<String, ArrayList<String>> identifiers = new HashMap<>();
        int lineNum = 1;

        while(in.hasNextLine()){
            String line = in.nextLine();
            String numberedline = "Line "+ lineNum+": " + line;

            Scanner getIdent = new Scanner(line);
            getIdent.useDelimiter("[^A-Za-z0-9_]+");

            while(getIdent.hasNext()){
                String identifier = getIdent.next();

                if(!identifiers.containsKey(identifier)){ //if identifier does not exist add it to the map
                    ArrayList<String> lines = new ArrayList<>();
                    lines.add(numberedline);

                    identifiers.put(identifier,lines);
                }
                else{//else  add line in the lines arraylist
                    identifiers.get(identifier).add(numberedline);
                }

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