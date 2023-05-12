
public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        int[] T = {10,7,9,4,7,5,2,2,1,6};
        heap.setT(T);
        heap.MakeHeap();
        heap.AlterHeap(5,8);
        heap.Insert(15);
        heap.ShowHeap();
        int[][] arr = { { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 } };
        System.out.println("Merged array is :");
        MinHeap.mergeKSortedArrays(arr, arr.length);
    }
}