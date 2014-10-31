package gui.pizza;

public class Configuration
{
    private String[] sizeNames = {"klein", "normal", "groß"};
    private int[] sizePrices = {600, 700, 800};
    private String[] toppingNames = {"Käse", "Tomaten", "Artischocken", "Pilze", "Spinat", "Ei", "Knoblauch", "Zwiebel"};
    private int[] toppingPrices = {0, 0, 80, 80, 80, 80, 50, 50};
    private int numberOfDefaultToppings = 2;
    
    public Configuration()
    {
        if(sizeNames.length != sizePrices.length)
        {
            throw new IllegalStateException("sizeNames do not match sizePrices");
        }
        if(toppingNames.length != toppingPrices.length)
        {
            throw new IllegalStateException("toppingNames do not match toppingPrices");
        }
        if(numberOfDefaultToppings > toppingNames.length)
        {
            throw new IllegalStateException("too many default toppings");
        }
    }

    public String[] getSizeNames()
    {
        return sizeNames;
    }

    public int[] getSizePrices()
    {
        return sizePrices;
    }

    public String[] getToppingNames()
    {
        return toppingNames;
    }

    public int[] getToppingPrices()
    {
        return toppingPrices;
    }

    public int getNumberOfDefaultToppings()
    {
        return numberOfDefaultToppings;
    }
}
