import java.util.Scanner;
/**
 * Shop item represents all types of items that are able to be found in the shop
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public abstract class ShopItem
{
    
    private String itemName;
    
    private String itemCode;
    
    private int cost;

    /**
     * Constructor for objects of class ShopItem
     */
    public ShopItem(String itemName, String itemCode, int cost)
    {
        this.itemName = itemName;
        
        this.itemCode = itemCode;
        
        this.cost = cost;
    }
    
    /**
     * Default constructor for ShopItem class.
     */
    public ShopItem()
    {
        itemName = "";
        itemCode = "";
        cost = 0;
    }
    
    /**
     * Retrieve the name of the item.
     */
    public String getItemName()
    {
        return itemName;
    }
    
    /**
     * Make a correction to the name of a item.
     */
    public void setItemName(String iN)
    {
        itemName = iN;
    }
    
    /**
     * Retrieve the code of the item.
     */
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * Make a correction to the code of an item.
     */
    public void setItemCode(String iC)
    {
        itemCode = iC;
    }
    
    /**
     * Retrieve the cost of the item.
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * Change how much an item costs.
     */
    public void setCost(int newCost)
    {
        cost = newCost;
    }

    /**
     * Print all details of the item.
     */
    public void printDetails()
    {
        System.out.println("Item name: " + itemName + "; " + "code: " + itemCode + "; " + "cost: " + cost + "; ");
    }
    
    /**
     * Read values for each of the item fields.
     */
    public void readData(Scanner scanner)
    {
        itemName = scanner.next();
        itemCode = scanner.next();
        cost = scanner.nextInt();
    }
}
