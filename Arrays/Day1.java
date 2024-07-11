package Arrays;

import java.util.Arrays;


public class Day1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        // ArrayRotation ar = new ArrayRotation();
        // ar.rotateArrayByKPlaces(arr, 3);
        // System.out.println(Arrays.toString(arr));
        int arr1[] ={1,2,3,4,5};
        int arr2[] = {2,3,4,7};
        UnionIntersection ui = new UnionIntersection();
        // int[] result = ui.intersection(arr1, arr2);
        // System.out.println(Arrays.toString(result));
        // int []union = ui.union(arr1, arr2);
        // System.out.println(Arrays.toString(union));
        int []zero = {1,2,3,0,0,4,0,5,6};
        MoveZeros mz = new MoveZeros();
        

        mz.moveZeros(zero);
        System.out.println();
        

    }
}
class MoveZeros{
    public void moveZeros(int []arr){
        int ptr=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[ptr] = arr[i];
                // System.out.print(arr[i]+" ");
                ptr++;
            }
        }
        System.out.println( Arrays.toString(arr));
    }
}
class UnionIntersection{
    public int[] union(int arr1[], int[] arr2){
        int length = arr1.length+arr2.length;
        int[] result = new int[length];
        int it = Math.max(arr1.length, arr2.length);
        int i=0;
        int ptr1=0;
        int ptr2 = 0;
        while(it>0){
            if(arr1[ptr1] == arr2[ptr2]){
                result[i] = arr1[ptr1];
                ptr1++;ptr2++;
            }
            else if(arr1[ptr1]>arr2[ptr2]){
                result[i] = arr2[ptr2];
                ptr2++;
            }
            else{
                result[i] = arr1[ptr1];
                ptr1++;
            }
            it--;i++;
        }
        return result;
    }
    public int[] intersection(int []arr1,int []arr2){
        int length = Math.min(arr1.length, arr2.length);
        int i = 0;
        int[] result = new int[length];
        int ptr1 = 0;
        int ptr2 = 0;
        while(length>0){
            if(arr1[ptr1] == arr2[ptr2]){
                result[i] = arr1[ptr1];
                ptr1++;
                ptr2++;
                i++;
            }
            else if(arr1[ptr1]>arr2[ptr2]){
                ptr2++;

            }else{
                ptr1++;
            }
            length--;
        }
        return result;
    }
}
class ArrayRotation{
    private void reverse(int arr[],int start,int end){
        while(start<=end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void rotateArrayByKPlaces(int []arr, int k){
        k=k%10;
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }
}
