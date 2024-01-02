package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {

    public static void main(String[] args) {

        //We've seen factory methods previously- where we call a static method on the class, and it returns a new
        //instance of a class for us.
        //Below we're calling a static method (List.of) that returns a list of String elements back, which we are
        //assigning to a variable (List<String> list).

        //The object coming back from this method isn't an array list.

        //When we print the result of list, we get a transformed array of String to a list of String.
        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);

        //Below, we are getting the class and the name of the object being returned from the List.of method.
        System.out.println(list.getClass().getName());
        //The result of this print shows us that this list is something called java.util.ImmutableCollections$ListN.
        //So what is this?
        //The list we're getting back is of type ListN, and it's a nested class within the ImmutableCollections class,
        //but most importantly, it's immutable.

        //Below, we're creating an array list of String using the variable groceries, and assigning a new instance of
        //the ArrayList to it.
        //We are also calling a constructor on ArrayList and passing an argument, list, which we created above.
        //The result of this instantiation is a new mutable array list populated with the elements from the immutable
        //list we passed.
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        //In the code below, we create a new ArrayList, but this time we just pass a list of Strings to the static method
        //on List (List.of), and we put that in our constructor parentheses.
        //This is one way to create and populate a small array list in one statement with a few known elements.
        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese")
        );
        System.out.println(nextList);

        //Below, we're adding everything in our first and second lists (groceries and nextList) with the addAll method,
        //and passing nextList to it.

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("Third item = " + groceries.get(2));

        if(groceries.contains("mustard")){
            System.out.println("List contains mustard");
        }

        groceries.add("yogurt");
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");
        System.out.println(groceries);

        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        //apples are not included in the result of .retainAll, because it didn't exist before the call.
        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        groceries.clear();
        System.out.println(groceries);
        //the method isEmpty returns true if there are no elements in the list.
        System.out.println("isEmpty = " + groceries.isEmpty());

        //Below, we use the static method List.of with a variable list of strings, then passing that result to the first
        //call to the addAll method on our groceries array list.
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        //Like List.of, Arrays.asList takes a variable argument list of elements and produces a list, and we can pass
        //that list to our second call to groceries.addAll method.
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        //Below, we're passing a new String array to the toArray method, which is initialized to the type and size we
        //want the returned array to be. In this case we want an array that has the same type and size as our list. This
        //method then returns an array of String.

        //There may be times where you would want to pass your data as an array to methods that accept arrays rather
        //than lists. Here we are passing the array to the Arrays.toString method, and print the array out, which we
        //know takes an array as an argument.
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
    }

}
