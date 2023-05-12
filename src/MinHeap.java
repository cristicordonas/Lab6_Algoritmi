public class MinHeap {
    private MinHeapNode[] harr;
    private int heap_size;
    public MinHeap(MinHeapNode[] a, int size) {
        heap_size = size;
        harr = a;
        int i = (heap_size - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l].getElement() < harr[i].getElement())
            smallest = l;
        if (r < heap_size && harr[r].getElement() < harr[smallest].getElement())
            smallest = r;
        if (smallest != i) {
            swap(harr, i, smallest);
            MinHeapify(smallest);
        }
    }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }
    MinHeapNode getMin(){
        if (heap_size <= 0) {
            System.out.println("Heap underflow");
            return null;
        }
        return harr[0];
    }
    void replaceMin(MinHeapNode root) {
        harr[0] = root;
        MinHeapify(0);
    }
    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    static void mergeKSortedArrays(int[][] arr, int K) {
        MinHeapNode[] hArr = new MinHeapNode[K];
        int resultSize = 0;
        for (int i = 0; i < arr.length; i++) {
            MinHeapNode node = new MinHeapNode(arr[i][0], i, 1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }
        MinHeap mh = new MinHeap(hArr, K);
        int[] result = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            MinHeapNode root = mh.getMin();
            result[i] = root.getElement();
            if (root.getJ() < arr[root.getI()].length) {
                root.setElement(arr[root.getI()][root.getJ()]);
                root.setJ(root.getJ() + 1);
            }
            else
                root.setElement(Integer.MAX_VALUE);
            mh.replaceMin(root);
        }
        printArray(result);
    }
}
