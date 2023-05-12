public class MinHeapNode {
    private int element;
    private int i;
    private int j;
    public MinHeapNode(int element, int i, int j) {
        this.element = element;
        this.i = i;
        this.j = j;
    }
    public int getElement() {
        return element;
    }
    public void setElement(int element) {
        this.element = element;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public int getJ() {
        return j;
    }
    public void setJ(int j) {
        this.j = j;
    }
}
