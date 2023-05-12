import java.util.ArrayList;

public class Heap {
    private int[] T;
    private int size;

    public Heap(int size) {
        T = new int[size+1];
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public int[] getT() {
        return T;
    }
    public void setT(int[] t) {
        System.arraycopy(t, 0, T, 1, size);
    }
    public void SlowMakeHeap() {
        for (int i = 2; i <= size; i++) {
            Percolate(T,i);
        }
    }
    public void Percolate(int[] T, int i) {
        int k = i;
        int j;
        do {
            j = k;
            if(j>1 && T[j/2] < T[k])
                k = j/2;
            int aux = T[j];
            T[j] = T[k];
            T[k] = aux;
        }while (j != k);
    }
    public void MakeHeap(){
        for (int i = size/2; i >= 1; i--) {
            SiftDown(T,i);
        }
    }
    public void SiftDown(int[] T, int i) {
        int k = i;
        int j;
        do {
            j = k;
            if(2*j <= size && T[2*j] > T[k])
                k = 2*j;
            if(2*j < size && T[2*j+1] > T[k])
                k = 2*j+1;
            int aux = T[j];
            T[j] = T[k];
            T[k] = aux;
        }while (j != k);
    }
    public void AlterHeap(int i, int v) {
        int x = T[i];
        T[i] = v;
        if(v < x)
            SiftDown(T,i);
        else
            Percolate(T,i);
    }
    public void Insert(int v) {
        size++;
        int[] aux = new int[size+1];
        if (size - 1 >= 0) System.arraycopy(T, 1, aux, 1, size - 1);
        aux[size] = v;
        T = new int[size+1];
        System.arraycopy(aux, 1, T, 1, size);
        MakeHeap();
    }
    public void ShowHeap() {
        int i = 1;
        int j = 1;
        while (i <= size) {
            for (int k = 0; k < j; k++) {
                if(i > size)
                    break;
                System.out.print(T[i] + " ");
                i++;
            }
            System.out.println();
            j *= 2;
        }
    }
}
