import java.util.Scanner;
/**
 * Hand tools are a type of tools which have additional fields that separate them from the other tools
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public class HandTool extends Tool
{    
    private boolean sharpenable;

    /**
     * Constructor for objects of class HandTool
     */
    public HandTool(String itemName, String itemCode, int cost, int timesBorrowed, boolean onLoan, int weight, boolean sharpenable)
    {
        super(itemName, itemCode, cost, timesBorrowed, onLoan, weight);
        this.sharpenable = sharpenable;
    }
    /**
     * Default constructor
     */
    public HandTool()
    {
        super();
        sharpenable = false;
    }

    /**
     * Check if a hand tool is sharpenable or not.
     */
    public boolean getSharpenable()
    {
        return sharpenable;
    }
    
    /**
     * Change whether or not a hand tool is sharpenable.
     */
    public void setSharpenable(boolean isSharpenable)
    {
        sharpenable = isSharpenable;
    }
    
    /**
     * Read values for each of the hand tools' fields.
     */
    public void readData(Scanner scanner1)
    {
        super.readData(scanner1);
        sharpenable = scanner1.nextBoolean();
        scanner1.close();
    }
    
    /**
     * Print all details of a tool including hand tool.
     */
    public void printDetails()
    {
        super.printDetails();
        if (sharpenable) {
            System.out.println("sharpenable: yes; ");
        }
        else {
            System.out.println("sharpenable: no; ");
        }
    }
}
