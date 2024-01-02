package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

//The record is a compact syntax that declares classes that are intended to be simple data carriers. It infers a lot of
//the boilerplate code like constructors, getter methods, equals(), hashCode(), and toString() methods.
record GroceryItem(String name, String type, int count){

    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }

}
public class Main {

    public static void main(String[] args) {

        //Declaring your arrays with a specific type allows compile time type checking.
        //Type checking at compile time prevents runtime exceptions when instances assigned to arrays aren't what they're
        //expected to be.
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        //If we don't specify type in the below example, it's going to use the Object class by default. This is called
        //the raw use of this type.
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");
        //In the above code, the strings might not be what the code wants or is expecting, which is generally not
        //behavior we want.

        //When you declare an array list, you probably know what data you want in that list.

        //In our case, it's a GroceryItem record, and we don't want anything else but GroceryItem in the list.

        //So how do we specify type for an array list? See below:

        //Using the <> symbols, below we're saying we want the type to be GroceryItem in our ArrayList object.
        //The <> is known as the diamond operator.
        //<GroceryItem> is specified after the ArrayList class.
        //The <> symbol can be used when Java can infer the type.
        //If we forget or remove the <> operator in the instantiation part of this statement, the compile time type
        //checking won't occur, which would allow other types to be potentially included in this array list. IntelliJ
        //gives us a warning about this if removed.
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        //groceryList.add("Yogurt");    Required type here is GroceryItem, but we provided a String.

        groceryList.add(new GroceryItem("milk"));
        groceryList.add(new GroceryItem("oranges", "PRODUCE", 5));
        //The below version of add takes an index as the first argument. What this does is, instead of adding this object
        //to the end of our list, add it to the first element in the list, moving all the other elements down.
        groceryList.add(0, new GroceryItem("apples", "PRODUCE", 6));
        //Above, if we use the .set method, we will replace the element instead of adding one and pushing the list down.

        groceryList.remove(1);
        //Above, we can also remove things from our list by specifying which index.
        System.out.println(groceryList);

    }

}

//An array is mutable, and we saw that we could set or change values in the array, but we could not resize it.

//Java gives us several classes that let us add and remove items, and resize a sequence of elements.

//These classes are said to implement a List's behavior.

//So what is a list?

//List is a special type in Java, called an interface.

//We can say that a List Interface describes a set of method signatures, that all List classes are expected to have.

//The arraylist is a resizable array.

//The ArrayList is a class that really maintains an array in memory, that's actually bigger than what we need in most
//cases.

//It keeps track of the capacity, which is the actual size of the array in memory.

//But it also keeps track of the elements that have been assigned or set, which is the size of the ArrayList.

//As elements are added to an ArrayList, its capacity may need to grow. This all happens automatically, behind the scenes.

//This is why the ArrayList is resizable.
