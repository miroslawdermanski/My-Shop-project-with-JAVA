import java.util.Scanner;
/**
 * Workwear is a type of accessory which has additional fields that separate it from the shop item.
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public class Workwear extends Accessory
{
    
    private String manufacturingStandard;
    
    private String colour;
    
    private char size;

    /**
     * Constructor for objects of class Workwear
     */
    public Workwear(String itemName, String itemCode, int cost, boolean isRecyclable, String manStandard, String colour, char size)
    {
        super(itemName, itemCode, cost, isRecyclable);
        
        this.manufacturingStandard = manStandard;
        
        this.colour = colour;
        
        this.size = size;        
    }
    
    public Workwear()
    {
        super();
        manufacturingStandard = "";
        colour = "";
        size = '\0';
    }
    
    /**
     * Get the value of manufacturing design.
     */
    public String getManStandard()
    {
        return manufacturingStandard;
    }
    /**
     * Set the data of manufacturing standard.
     */
    public void setManStandard(String nMS)
    {
        manufacturingStandard = nMS;
    }
    
    /**
     * Get the colour of an accessory.
     */
    public String getColour()
    {
        return colour;
    }
    /**
     * Set the colour of a workwear.
     */
    public void setColour(String newColour)
    {
        colour = newColour;
    }
    
    /**
     * Get the size of an accessory.
     */
    public char getSize()
    {
        return size;
    }
    /**
     * Set the size of a workwear.
     */
    public void setSize(char newSize)
    {
        size = newSize;
    }
    
    /**
     * Read values for each of the accessories fields.
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        manufacturingStandard = scanner.next();
        colour = scanner.next();
        size = scanner.next().charAt(0);
    }
    
    /**
     * Print all details of an accessory including workwear.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Manufacturing standard: " + manufacturingStandard + "; " + "Colour: " + colour + "; " + "size: " + size + "; ");
    }   
}
