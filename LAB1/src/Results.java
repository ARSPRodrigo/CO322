import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Prasanna on 2/2/2015.
 */
public class Results {

    public static void main(String []args) throws IOException {


        String line;
        // create file reader
        FileReader fileRd = new FileReader("results.txt");
        BufferedReader readFile = new BufferedReader(fileRd);
        int [] bubble = new int[40];
        int [] selection = new int[40];
        int [] insertion = new int[40];

        int i = 0,j=0,k=0;
        while((line = readFile.readLine()) != null) {

            if(line.contains("bubble")){
                bubble[i] = Integer.parseInt(line.split(": ")[1]);
                i++;
            }
            else if(line.contains("selection")){
                selection[j] = Integer.parseInt(line.split(": ")[1]);
                j++;
            }
            else if(line.contains("insertion")){
                insertion[k] = Integer.parseInt(line.split(": ")[1]);
                k++;
            }
        }
        System.out.println(Arrays.toString(bubble));
        System.out.println(Arrays.toString(selection));
        System.out.println(Arrays.toString(insertion));

    }

}
