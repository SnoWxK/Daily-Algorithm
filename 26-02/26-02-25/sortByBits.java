public class sortByBits {
    private boolean compare(int a, int b) {
        int count1 = Integer.bitCount(a);
        int count2 = Integer.bitCount(b);
        if (count1 == count2) {
            return a > b;
        }
        return count1 > count2;
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while(low < high){
            while(low<high&&compare(arr[high],pivot)){
                high--;
            }
            arr[low] = arr[high];
            while(low<high&&compare(pivot,arr[low])){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    private void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int pivot = partition(arr,left,right);
        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1,right);
    }
    public int[] sortByBits(int[] arr) {
        quickSort(arr,0,arr.length-1);
        return arr;
    }
}
