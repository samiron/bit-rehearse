package of.samiron.mylibs;

public class MergeSorter<T extends Comparable> extends Sorters<T> {

    public MergeSorter(T[] items) {
        super(items);
    }

    @Override
    public void sort() {
        mergeSort(0, items.length - 1);
    }

    private void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int midpoint = (start + end) / 2;
        mergeSort(start, midpoint);
        mergeSort(midpoint + 1, end);
        merge(start, end, midpoint);
    }

    private void merge(int start, int end, int midpoint) {
        int i = start;
        int j = midpoint + 1;
        while (i <= midpoint) {
            if (this.items[i].compareTo(this.items[j]) > 0) {
                swap(i, j);
                push(j, end);
            }
            i++;
        }
    }

    private void push(int start, int end) {
        while (start < end) {
            if(this.items[start].compareTo(this.items[start+1]) > 0){
                swap(start, start + 1);
                start ++;
            } else {
                break;
            }
        }
    }

    /**
     * Another sort function will receive a comparison function which
     * can be used to customize the sorting behavior.
     */
}
