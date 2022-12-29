package com.computerscience.JamesArtusoPizzaAndroid;
/**
 * Interface class that contains methods to create pizzas.
 * Implemented by chicago and NY style classes.
 * @author James Artuso
 */

public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
