/**
 * @author ChanceZhou
 * @code this file2022-07-30-20:24
 */
public class bubbleSort {
    public int[] bubbleSort (int[] arr) {
        // write code here
        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j <arr.length - i ;j++ ){
                if(arr[j] >arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
