import java.util.*;

/**
 * This is the class which will take the numbers generated from the
 * Numbers class and then print them out in a ticket format.
 */
public class Ticket
{
    /**
     * @param SimpleInput initialise new instance of the simple input class
     * @param lines int variable for number of lines the user enters
     * @param ArrayList<Numbers> new array list
     */
    private SimpleInput si = new SimpleInput();
    private int lines;
    private ArrayList<Numbers> ticket = new ArrayList<Numbers>();

    /**
     * Constructor to check the user enters a number over 0 and then
     * start the ticket creating process
     */
    public Ticket()
    {
        checkNumber();
    }

    /**
     * The actual method that checks the users number and creates the ticket
     */
    private void checkNumber()
    {
        lines = si.getInt("How many lines do you want?");
        
        if(lines<1)
        {
            System.out.println("Please enter a number above 0");
            checkNumber();
        }
        else
        {
            makeTicket();
        }
    }
    
    
    /**
     * Method that prints the ticket itself, adds a 0 to any single digit
     * then repeats for as many lines as the user enters. Each line is also
     * added to the ArrayList
     */
    public void makeTicket()
    {
        System.out.println("******************************");
        System.out.println("*****                    *****");
        System.out.println("*****    LOTTO TICKET    *****");
        System.out.println("*****                    *****");
        System.out.println("******************************");

        for(int z=0;z<lines;z++)
        {
            Numbers line = new Numbers(); // Generate a new line of numbers
            System.out.print("***");  // Left ticket edge
            ticket.add(line); // add line to the array list to be recalled.

            for(int k=0;k<6;k++) //If K is less than 6
            {
                System.out.print(" ");

                if(line.numbers[k] < 10)
                {
                    System.out.print("0");
                }

                else {}

                System.out.print(line.numbers[k]);
                System.out.print(" ");
            }
            System.out.print("***"); // Right ticket edge
            System.out.println("");  // Create new line ready for the next line of numbers
        }
        System.out.println("******************************"); // Bottom of ticket
    }

    
    /**
     * Method to recall the information in the ArrayList and reprint the ticket
     */
    public void reprintTicket()
    {
        System.out.println("******************************");
        System.out.println("*****                    *****");
        System.out.println("*****    LOTTO TICKET    *****");
        System.out.println("*****      (REPRINT)     *****");
        System.out.println("*****                    *****");
        System.out.println("******************************");
        Numbers tempLine;

        for(int z=0;z<ticket.size();z++)
        {
            System.out.print("***");  // Left ticket edge.
            tempLine = ticket.get(z);

            for(int k=0;k<6;k++) //If K is less than 6
            {

                System.out.print(" ");

                if(tempLine.numbers[k] < 10)
                {
                    System.out.print("0");
                }

                else {}

                System.out.print(tempLine.numbers[k]);
                System.out.print(" ");
            }
            System.out.print("***"); // Right ticket edge
            System.out.println("");  // Create new line ready for the next line of numbers

        }

        System.out.println("******************************"); // Bottom of ticket
    }

}
