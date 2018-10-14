
package arraycount;

import java.util.Arrays;
import java.util.Random;

/**
 * Algorithm to find the dominant element in an array
 * @author Daniel Banks
 */
public class ArrayCount {

    public static int arrayCount(int [] searchArray){
        int count = 0;
        int domElement = searchArray[0];
        for(int element: searchArray){
            if(count == 0){
                domElement = element;
                count = 1;
            }else if(domElement == element){
                count++;
            }else{
                count--;
            }
        }
        
        count = 0;
        for(int i = 0; i<searchArray.length; i++){
            if(searchArray[i]==domElement){
                count++;
            }
        }
        
        if(count > (searchArray.length)/2){
            return domElement;
        }else{
            return -1;
        }
    }
    
    public static void main(String[] args) {
        //Test Pass-------------------------------------------------------------
        System.out.println("Test Pass");
        int[] testArray = {456,23,456,65,456,12,456};
        System.out.println(Arrays.toString(testArray));
        int domIndex = arrayCount(testArray);
        
        if(domIndex>0){
            System.out.println(domIndex+" dominates this array.");
        }else{
            System.out.println("No value dominates this array.");
        }
        System.out.println("");
        
        //Test Fail-------------------------------------------------------------
        System.out.println("Test Fail");
        int[] testArray1 = {456,456,456,45,23,12};
        System.out.println(Arrays.toString(testArray1));
        domIndex = arrayCount(testArray1);
        
        if(domIndex>0){
            System.out.println(domIndex+" dominates this array.");
        }else{
            System.out.println("No value dominates this array.");
        }
        System.out.println("");
        
        //Test Random Arrays----------------------------------------------------
        System.out.println("Test Random Arrays");
        Random rand = new Random();
        int maxInt = 3;
        int maxArraySize = 5;
        
        for(int i = 0; i < 10; i++){
            int arraySize = rand.nextInt(maxArraySize)+1;
            int[] array = new int[arraySize];
            
            for(int j = 0; j<arraySize; j++){
                array[j]= rand.nextInt(maxInt)+1;
            }
            
            System.out.println(Arrays.toString(array));

            domIndex = arrayCount(array);
            if(domIndex>0){
                System.out.println(domIndex+" dominates this array.");
            }else{
                System.out.println("No value dominates this array.");
            }
            System.out.println("");
        }
    }
}
