import java.util.Scanner;

/**
 * Tool is a class representing a type of a shop item which has additional fields and functions that add on top of a shop item.
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public abstract class Tool extends ShopItem
{

    private int timesBorrowed;

    private boolean onLoan;

    private int weight;

    /**
     * Constructor for objects of class Tool
     */
    public Tool(String itemName, String itemCode, int cost, int timesBorrowed, boolean onLoan, int weight)
    {
        super(itemName, itemCode, cost);

        this.timesBorrowed = timesBorrowed;

        this.onLoan = onLoan;

        this.weight = weight;       

    }

    /**
     * Default constructor.
     */
    public Tool()
    {
        super();
        timesBorrowed = 0;
        onLoan = false;
        weight = 0;
    }

    /**
     * Get the number of times that the item has ben borrowed.
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }

    /**
     * Change the number of times a tool has been borrowed.
     */
    public void setTimesBorrowed(int tB)
    {
        timesBorrowed = tB;
    }

    /**
     * Find out if an item is currently available.
     */
    public boolean getOnLoan()
    {
        return onLoan;
    }

    /**
     * Make a correction to the availability of a tool.
     */
    public void setOnLoan(boolean newLoan)
    {
        onLoan = newLoan;
    }

    /**
     * Retrieve the weight of the item.
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Change the weight of a tool.
     */
    public void setWeight(int newWeight)
    {
        weight = newWeight;
    }

    /**
     * Print all details of the tool.
     */
    public void printDetails()
    {
        System.out.println();
        System.out.println("----Tool items----");
        super.printDetails();
        System.out.println("timesBorrowed: " + timesBorrowed + "; ");

        if(onLoan)
        {
            System.out.print("onLoan: yes; ");
        }
        else
        {
            System.out.print("onLoan: no; ");
        }

        System.out.print("weight: " + weight + "; ");

    }

    /**
     * Read values for each of the tools' fields.
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        timesBorrowed = scanner.nextInt();
        onLoan = scanner.nextBoolean();
        weight = scanner.nextInt();
    }
}
