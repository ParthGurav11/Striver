package Arrays;

import java.util.Arrays;

public class BasicArrayPbm {
    public static void main(String[] args) {
        // int[] arr = {2,8,4,6,1,9,11,5};
        LargestElement obj = new LargestElement();
        // int largest = obj.bruteForceSearch(arr);
        // // System.out.println("The largest element is: "+largest);
        // int []cn = {12, 35, 1, 10, 34, 1};
        // int secLargest = obj.secLargestOptimal(cn);
        // System.out.println(secLargest);
        int sorted[] = {2,3,3,3,5,5,7,7,7,8,9,11};
        RemoveDuplicate dup = new RemoveDuplicate();
        dup.removeDuplicates(sorted);
    }
}
class RemoveDuplicate{
    public void removeDuplicates(int []arr){
        int ptr = 0;Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[ptr]){
                continue;
            }else if(arr[i]!=arr[ptr]){
                ptr+=1;
                arr[ptr] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
class LargestElement{
    public LargestElement(){}
    public int bruteForceSearch(int []arr){
        int largest = Integer.MIN_VALUE;
        for (int i : arr) {
            if(largest<i){
                largest = i;
            }
        }
        return largest;
    }
    public int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            if(arr[i]>largest){

                largest = arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]>secLargest && arr[i]!=largest ){
                secLargest = arr[i];
                // System.out.println(secLargest);
            }

        }
        // System.out.println(largest);
        return secLargest;
    } 
    public int secLargestOptimal(int arr[]){
        int largest = arr[0];
        int secLargest = -1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                secLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]<largest && arr[i]>secLargest){
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}
