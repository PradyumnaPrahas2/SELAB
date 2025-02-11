package Greedy;
import java.util.*;
public class maxFrequencyAfterKoperations {

    public static boolean check(int[] arr,int mid,int k){

        for(int i=mid;i<arr.length;i++){
            int cur=arr[i];
            int diff=0;
            for(int j=i;j>i-mid;j--){
                diff+=(cur-arr[j]);
            }
            if(diff<=k){
                return true;
            }
        }
        return false;
    }

    public static int valueAfterKincrements(int[] arr,int k){
        Arrays.sort(arr);

        int l=0,r=arr.length;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(check(arr,mid,k)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {

        int[] arr = {3,9,6};
        int k = 2;

        System.out.print(valueAfterKincrements(arr,k));
    }
}
