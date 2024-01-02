package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayVsArrayList {

    public static void main(String[] args) {

        String[] originalArray = new String[] {"First", "Second", "Third"};
        //originalList is backed by originalArray, which means we have access to originalLists methods to make changes
        //to the array that backs it (originalArray).
        var originalList = Arrays.asList(originalArray);

        originalList.set(0, "one");
        System.out.println("list: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray));
        //Above, we set originalLists first element to "one". Since originalList is backed by originalArray, changing
        //originalList also changes originalArray.
        //Any method we use on the list will have an effect on the array that was the source of the list.

        originalList.sort(Comparator.naturalOrder());
        System.out.println("array: " + Arrays.toString(originalArray));

        //The code below will throw an exception, since we are now unable to change the size of originalList.
        //originalList.remove(0);
        //originalList.add("fourth");

        //If we want to use ArrayLists functionality (methods) on arrays, we would do something like we see above.
        //This is done if we want to manipulate the underlying array (Like using .naturalOrder method to sort the
        //array).

        //Below, we can use code to create an ArrayList of a fixed size:

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);

    }

}

//Below we can see that arrays and ArrayLists have more in common than they don't:

//  Feature                         array                     ArrayList
//primitive types supported         Yes                       No
//indexed                           Yes                       Yes
//ordered by index                  Yes                       Yes
//duplicates allowed                Yes                       Yes
//nulls allowed                     Yes(for non-primitives)   Yes
//resizable                         No                        Yes
//mutable                           Yes                       Yes
//inherits from java.util.Object    Yes                       Yes
//implements List interface         No                        Yes

//Instantiating without Values:

//Instantiating Arrays                                  Instantiating ArrayLists

//String[] array = new String[10];                      ArrayList<String> arrayList = new ArrayList<>();

//An array of 10 elements is created, all               An empty ArrayList is created.
//with null references. The compiler will
//only permit Strings to be assigned to                 The compiler will check that only Strings
//the elements.                                         are added to the ArrayList.

//An array requires square brackets in the declaration.

//In the new instance, square brackets are also required, with a size specified inside.

//An ArrayList should be declared, with the type of the element in the ArrayList, in angle brackets.

//We can use the diamond operator, when creating a new instance in a declaration statement.

//You should use a specific type, rather than just the Object class, because Java can then perform compile-time type
//checking.

//String[] array = new String[] {"first", "second", "third"};       ArrayList<String> arrayList = new ArrayList<>(List
//                                                                  .of("first", "second", "third"));

//An array of 3 elements is created, with                           An ArrayList can be instantiated by passing another
//                                                                  list to it as we show here.
//elements[0] = "first"
//elements[1] = "second"                                            We can us the List.of() factory method, which uses
//elements[2] = "third"                                             variable arguments, to create a pass through
//                                                                  immutable list.
//Alternatively, we can use this array initializer
//(anonymous array):

//String[] array = {"first", "second", "third"};

//You can use an array initializer, to populate array elements during array creation.
//This feature lets you pass all the values in the array as a comma delimited list in curly braces.

//For the ArrayList, you can use an ArrayList constructor that takes a collection, or list of values, during ArrayList
//creation.

//The List.of method can be used to create such a list, with a variable argument list of elements.

//                                  Accessing Array Element Data                    Accessing ArrayList Element Data

//                                  String[] arrays = {"first",                       ArrayList<String> arrayList = new
//                                  "second", "third"};                                "second", "third"));                                                                 ArrayList<>(List.of("first",
//
//Index value of first element              0                                                   0
//Index value of last element           arrays.length - 1                               arrayList.size() - 1
//Retrieving number of elements         int elementCount = arrays.length;               int elementCount = arrayList.size();
//Setting(assigning an element)         arrays[0] = "one";                              arrayList.set(0, "one");
//Getting an element                    String element = arrays[0];                     String element = arrayList.get(0);

//The number of elements is fixed when an array is created.
//We can get the size of the array from the attribute length, on the array instance.
//Array elements are accessed with the use of square brackets and an index that ranges from 0, to one less than the
//number of elements.

//The number of elements in an ArrayList may vary, and can be retrieved with a method on the instance, named size().
//ArrayList elements are accessed with get and set methods, also using an index ranging from 0, to one less than the
//number of elements.

//Array lists come with built-in support for printing out elements, including nested lists:
//System.out.println(arrayList);

//Arrays don't, so you need to call Arrays.toString, passing the array as an argument:
//System.out.println(Arrays.toString(arrays));

//              Array                                             ArrayList

//      Array creation code                                     ArrayList creation code
//      String[][] array2d = {                                  ArrayList<ArrayList<String>> multiDList = new ArrayList<>();
//      {"first", "second", "third"},
//      {"fourth", "fifth"}
//      };

//Printing multidimensional arrays vs. ArrayList:

//Array elements:

//System.out.println(Arrays.deepToString(array2d));

//ArrayList elements:

//System.out.println(System.out.println(multiDList));

//A multidimensional ArrayList simply has a type, which in itself is an ArrayList.

//Finding an element in an Array or ArrayList:

//Arrays:

//int binarySearch(array, element)

//**Array MUST BE SORTED

//Not guaranteed to return index of first element if there are duplicates.

//For arrays, we can use the binarySearch method, to find a matching element, although this method requires that the
//array be sorted first.

//In addition, if the array contains duplicate elements, the index returned from the search is not guaranteed to be
//the position of the first element.

//ArrayLists:

//boolean contains(element)

//boolean containsAll(list of elements)

//int indexOf(element)

//int lastIndexOf(element)

//We can use contains or containsAll, which simply returns a boolean if a match or matches were found.

//In addition, like the String or StringBuilder, we have the methods, indexOf and lastIndexOf, which will return
//the index of the first or last match.

//When a -1 is returned from these methods, no matching entry was found.

//Sorting:

//              Array                                                        ArrayList

//              String[] arrays = {"first", "second", "third"};              ArrayList<String> arrayList = new ArrayList
//                                                                           <>(List.of("first", "second", "third"));

//              Arrays.sort(arrays);                                         arrayList.sort(Comparator.naturalOrder());
//                                                                           arrayList.sort(Comparator.reverseOrder());

//              You can only sort arrays of elements that implement          You can use the sort method with static
//              Comparable.                                                  factory methods to get Comparators.

//Arrays:

//We can use the Arrays.sort method for arrays with numeric primitive types and wrapper classes, as well as Strings
//and StringBuilders.

//For the ArrayList, we can use the sort method, again for numeric wrapper classes, Strings and StringBuilders.

//ArrayLists:

//We pass ArrayList's sort method, a Comparator type argument, that specifies just how to sort.
//We call static methods on the Comparator type, to get a Comparator for either a natural order, or to reverse order sort.

//Array as an ArrayList:

//String[] originalArray = new String[] {"First", "Second", "Third"};
//var originalList = Arrays.asList(originalArray);

//There are times when you'll want to switch between an Array and an ArrayList, and we find support for this on both the
//Arrays class and the ArrayList class.

//The Arrays.asList method returns an ArrayList backed by an array.

//Above, we show the creation of a three element array.

//Then the code uses the Arrays.asList method, passing it the array, and assigning it to a variable, using the var
//keyword to a variable named originalList.

//We can think of this conceptually as putting an ArrayList wrapper around an existing array.

//Any change made to the List is a change to the array that backs it.

//This also means that an ArrayList created by this method is not resizable.

//Creating Special Kinds of Lists:

//      Using Arrays.asList                                             Using List.of
//  Returned List is NOT resizable, but is mutable.                 Returned list is IMMUTABLE

//var newList = Arrays.asList("Sunday","Monday","Tuesday");         var listOne = List.of("Sunday","Monday","Tuesday");
//String[] days = new String[] {"Sunday","Monday","Tuesday"};       String[] days = new String[] {"Sunday","Monday",
                                                                  //"Tuesday"};

//List<String> newList = Arrays.asList(days);                       List<String>listOne = List.of(days);

//Above demonstrates two ways of creating a list form elements, or from an array of elements.

//Both are static factory methods on types.

//The first is the asList method on the Arrays class, and it returns a special instance of a List, that is not resizable,
//but is mutable.

//The second is the of method on the List interface, and it returns a special instance of a List, that is immutable.

//Both support variable arguments, so you can pass a set of arguments of one type, or you can pass an array.

//We show examples of both above, first using variable arguments, and second passing an array.

//Creating Arrays from ArrayLists:

//ArrayList<String> stringLists = new ArrayList<>(List.of("Jan","Feb","Mar"));
//String[] stringArray = stringLists.toArray(new String[0]);

//Above shows the most common method to create an array from an ArrayList, using the method toArray().

//The method takes one argument, which should be an instance of a typed array.

//The method returns an array of that same type.

//If the length of the array you pass has more elements than the list, extra elements will be filled with the default
//values for that type.

//If the length of the array you pass has less elements than the list, the method will still return an array with the
//same number of elements in it as is in the list.

//In the example shown above, we pass a String array with zero as the size, but the array returned has three elements,
//which is the number of elements in the list.