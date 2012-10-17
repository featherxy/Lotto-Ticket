import java.util.Random;
import java.util.Arrays;
/**
 * This class will generate a line for the Ticket class. The ticket class will define the number of lines the player has specified, and will run this code to generate a line of numbers for each line specified.
 * 
 * @author Duncan Ogle
 * @version 1.8
 */

public class Numbers
{
    /**
     * @param int[] numbers is an array designed to hold the 6 numbers of the lottery ticket line.
     * @param Random initialise random number generator
     * @param d boolean value for setting if something is a duplicate or not
     */

    int numbers[] = new int[6];  // The array where the numbers are stored
    Random generator = new Random();  // Random number generator
    boolean d = false;

    /**
     * Constructor to call the generateLine method as soon as the ticket is created.
     */
    public Numbers()
    {
        generateLine();
    }

    // This method generates a random number for each part of the array between 0 and 48
    private int generateNumber()
    {
        return generator.nextInt(49);
    } 

        
    /**
     * the +1 at the end of generateNumber is there as a simple fix for not allowing the number 0 in the draw. Instead of checking each number generated if its the number 0, I simply make the number generators max number 1 less than it needs to be, then add one to whatever number is generated. This way the number 0 can never be chosen and will always be between 1 and 49.
     * 
     * @param z z is a very simple throwaway variable used for counting ina  loop
     */

    public void generateLine()
    // Populates each line with a set of numbers in an array
    {
        for(int z=0;z<6;z++)
        {
            numbers[z] = generateNumber()+1;  
        }

        // sort array
        Arrays.sort(numbers);

        // loop to find if the line has a duplicate
        checkDuplicates();

        if(d == true)
        {
            d=false;
            generateLine();
        }
        else {}

    }

    /**
     * checkDuplicates is used to check for any duplicates in a line
     */

    private void checkDuplicates()
    {
        for(int z = 0; z < 6; z++){
            if(numbers[z] == numbers[z]+1) {
                d=true;
            }

            
        }

    }
}



