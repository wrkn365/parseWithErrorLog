package jonphase4db2working;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Jon Janet 7/5/2011
 * class Main reads city, state, and population from a text file then if the population
 * of the city is greater than or equal to 50,000, it writes the city information to
 * a text file called BigCities.txt.If the population of the city is less than
 * 50,000, it writes the city information to a text file called SmallCities.txt.
 * If the output files already exist, it will append to the file and not overwrite it.
 * If there are errors parsing a line, that line will be sent to a file called ErrorLog.txt.
 */
public class Main
{

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // read input stream from file
        File input = new File("states.txt");
        FileReader reader = new FileReader(input);
        BufferedReader in = new BufferedReader(reader);

        // create new files
        CityWriter bigCities = new CityWriter(new FileWriter("BigCities.txt",true));
        CityWriter smallCities = new CityWriter(new FileWriter("SmallCities.txt",true));
        FileWriter log = new FileWriter ("ErrorLog.txt",true);
        BufferedWriter error = new BufferedWriter(log);

        String line;
        while ((line = in.readLine()) != null)
        {
            Cities info = parseWithTokenizer(line);
            if (info == null)// if line is null, print error message and write to errorLog.txt
            {
                System.out.println("Could not parse line: " + line);
                System.out.println("This line will be sent to log: ErrorLog.txt");
                error.write(line);
                error.newLine();
                continue;
            }
            if (info.getPop() >= 50000)// if population is 50000 or over write to BigCities.txt
            {
                bigCities.write(info);
            } else // if population is less than 50000 write to SmallCities.txt
            {
                smallCities.write(info);
            }
        }
        // close output streams
        bigCities.close();
        smallCities.close();
        error.close();
    }// close Main method
    /**
     * parseWithTokenizer sets delimiter as "," and trims extra spaces from line
     * @param line
     * @return
     */
    private static Cities parseWithTokenizer(String line)
    {
        String city;
        String state;
        int pop;


        try
        {
            StringTokenizer tokens = new StringTokenizer(line, ",");
            city = tokens.nextToken().trim();
            state = tokens.nextToken().trim();
            pop = Integer.parseInt(tokens.nextToken().trim());
        } catch (Exception e)
        {
            return null;
        }


        return new Cities(city, state, pop);

    }// close parseWithTokenizer
}// end class Main

