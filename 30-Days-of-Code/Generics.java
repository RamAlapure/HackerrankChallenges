import java.lang.reflect.Method;

class Solution {
    //Write your code here

    public static <T> void printArray (T[] array){
        for(T a : array)
            System.out.println(a);
        //arrayList.forEach(System.out::println);
    }
    
    public static void main(String args[]){
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };
        
        printArray( intArray  );
        printArray( stringArray );
        
        if(Solution.class.getDeclaredMethods().length > 2){
            System.out.println("You should only have 1 method named printArray.");
        }
    }
}

