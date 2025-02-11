import java.util.*;
public class Challenge{

    public static void Compute(int[] arr1,int[] arr2){
        // TC --> O(m*n)  SC --> O(1)
        int i=0,j=0;
        while(true){
            while(i<arr1.length && arr1[i]<arr2[0]){
                i++;
            }
            if(i<arr1.length && arr1[i]>arr2[0]){
                int temp=arr1[arr1.length-1];
                for(int k=arr1.length-1;k>i;k--){
                    arr1[k]=arr1[k-1];
                }
                arr1[i]=arr2[0];
                int s=0;
                for(int k=1;k<arr2.length;k++){
                    if(temp>arr2[k]){
                        arr2[k-1]=arr2[k];
                    }
                    else{
                        arr2[k-1]=temp;s++;break;
                    }
                }
                if(s==0){
                    arr2[arr2.length-1]=temp;
                }
            }
            else{
                return;
            }
        }
    }

    public static void getAns(int[] arr1,int[] arr2){
        // TC -->O(M+N)  SC --> O(M+N)
        int[] merge=new int[arr1.length+arr2.length];
        int count=0,i=0,j=0;
        while(count<arr1.length+arr2.length){
            if(i<arr1.length && j<arr2.length){
                if(arr1[i]<arr2[j]){
                    merge[count]=arr1[i];i++;
                }
                else{
                    merge[count]=arr2[j];j++;
                }
                count++;
            }
            else if(i<arr1.length){
                merge[count]=arr1[i];count++;i++;
            }
            else{
                merge[count]=arr2[j];count++;j++;
            }
        }
        i=0;j=0;int c=0;
        while(i<arr1.length){
            arr1[i]=merge[c];c++;i++;
        }
        while(j<arr2.length){
            arr2[j]=merge[c];c++;j++;
        }
    }

    public static void SortingWay(int[] arr1,int[] arr2){
        // TC --> O(m+ nlogn)  SC --> O(1)
        int i=0,j=0;
        while(i<arr1.length){
            if(arr1[i]>arr2[j]){

                int temp=arr1[arr1.length-1];
                for(int k=arr1.length-1;k>i;k--){
                    arr1[k]=arr1[k-1];
                }
                arr1[i]=arr2[j];
                arr2[j]=temp;
                j++;
            }
            i++;
        }
        Arrays.parallelSort(arr2);
    }
    public static void main(String... args){
        Scanner x=new Scanner(System.in);
        int n1=x.nextInt();
        int n2=x.nextInt();
        int[] arr1=new int[n1];
        int[] arr2=new int[n2];
        for(int i=0;i<n1;i++) arr1[i]=x.nextInt();
        for(int i=0;i<n2;i++) arr2[i]=x.nextInt();

        // Compute(arr1,arr2);// O(M*N)

        // SortingWay(arr1,arr2); // O(M+N)

        getAns(arr1, arr2);
        System.out.print(Arrays.toString(arr1));
        System.out.print(Arrays.toString(arr2));

    }
    
}