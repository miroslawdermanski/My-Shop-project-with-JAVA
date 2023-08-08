import java.util.Scanner;
/**
 * Electric tools are a type of tools which have additional fields that separate them from the other tools
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public class ElectricTool extends Tool
{   
    private boolean rechargeable;
    
    private String power;

    /**
     * Constructor for objects of class ElectricTool
     */
    public ElectricTool(String itemName, String itemCode, int cost, int timesBorrowed, boolean onLoan, int weight, boolean rechargeable, String power)
    {
        super(itemName, itemCode, cost, timesBorrowed, onLoan, weight);
        this.rechargeable = rechargeable;
        this.power = power;
    }
    /**
     * Default constructor
     */
    public ElectricTool()
    {
        super();
        rechargeable = false;
        power = "";
    }

    /**
     * Check if an electric tool is rechargeable.
     */
    public boolean getRechargeable()
    {
        return rechargeable;
    }
    
    /**
     * Make changes whether an electric tool is rechargeable or not.
     */
    public void setRechargeable(boolean isRechargeable)
    {
        rechargeable = isRechargeable;
    }
    
    /**
     * Check the power of a electric tool.
     */
    public String getPower()
    {
        return power;
    }
    
    /**
     * Change the power of an electric tool.
     */
    public void setPower(String mPower)
    {
        power = mPower;
    }
    
    /**
     * Read values for each of the electric tools' fields.
     */
    
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        rechargeable = scanner.nextBoolean();
        power = scanner.next();
        scanner.close();
    }
    
    /**
     * Print all details of a tool including electric tool.
     */
    public void printDetails()
    {
        super.printDetails();
        if (rechargeable) {
            System.out.println("rechargeable: yes; ");           
        }
        else {
            System.out.println("rechargeable: no; ");
        }
        System.out.println("power: " + power + "; ");
    }
}
