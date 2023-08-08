import java.util.Scanner;
/**
 * Accessory is a class representing a type of a shop item which has additional fields and functions that add on top of a shop item.
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public abstract class Accessory extends ShopItem
{

    private boolean isRecyclable;

    /**
     * Constructor for objects of class Accessory
     */
    public Accessory(String itemName, String itemCode, int cost, boolean isRecyclable)
    {
        super(itemName, itemCode, cost);

        this.isRecyclable = isRecyclable;
    }

    /**
     * Constructor for objects of class Accessory
     */
    public Accessory()
    {
        super();
        isRecyclable = false;
    }

    /**
     * Check if an accessory is recyclable or not.
     */
    public boolean getIsRecyclable()
    {
        return isRecyclable;
    }
    /**
     * Set if an accessory is recyclable or not.
     */
    public void setIsRecyclable(boolean newIsRec)
    {
        isRecyclable = newIsRec;
    }
    
    /**
     * Read values for each of the accessories fields.
     */
    public void readData(Scanner scanner)
    {
        isRecyclable = scanner.nextBoolean();
        super.readData(scanner);      
    }
    
    /**
     * Print all details of the item.
     */
    public void printDetails()
    {
        System.out.println();
        System.out.println("----Accessory items----");
        System.out.println("isRecyclable: " + isRecyclable + "; ");
        super.printDetails();
    }

}
