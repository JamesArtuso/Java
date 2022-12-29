package com.computerscience.JamesArtusoPizzaAndroid;

import java.io.Serializable;

/**
 * Enum class for toppings. A toppings array is a field of the pizza data type.
 * @author James Artuso
 */

public enum Topping implements Serializable {
    SAUSAGE ("Sausage"),
    PEPPERONI ("Pepperoni"),
    GREENPEPPER ("Green Pepper"),
    ONION ("Onion"),
    MUSHROOM ("Mushroom"),
    BBQCHICKEN ("BBQ Chicken"),
    PROVOLONE ("Provolone"),
    CHEDDAR ("Cheddar"),
    BEEF ("Beef"),
    HAM ("Ham"),
    BACON ("Bacon"),
    OLIVES( "Olives"),
    SPINACH("Spinach");

    private final String NAME;

    /**
     * Constructor used to make topping data type.
     * Has field name, name of the topping.
     * @param name, name that the field will be set to.
     */
    Topping(String name){
        this.NAME = name;
    }

    /**
     * Method to return a string containing the name of the topping.
     * @return string, returns name of topping as string.
     */
    @Override
    public String toString(){
        return NAME;
    }

    public static Topping getFromString(String t){
        System.out.println(t.substring(0,1));
        for(Topping topping:values()){
            if(t.equals(topping.NAME)){
                return topping;
            }
        }
        return null;
    }
}
