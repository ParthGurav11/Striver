package Arrays;

public class ChkSorted {
    public static boolean chkSorted(int[] arr){
        boolean flag = true;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                flag = false;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,7,9};
        System.out.println(chkSorted(arr));
        if (chkSorted(arr)) {
            System.out.println("Yes the array is sorted!");
        }else{
            System.out.println("The array is not sorted");
        }
    }

}

class Duplicate{
    public void removeDuplicate(int []arr){
        int n=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>n){
                n=arr[i];
            }

        }
        int []helper = new int[n];
        for(int i=0;i<arr.length;i++){
            helper[arr[i]]++;
        }
        int ptr = 0;
        for(int i=0;i<arr.length;i++){
            if(helper[i]>0){
                arr[i] = 
            }
        }
    }
}
