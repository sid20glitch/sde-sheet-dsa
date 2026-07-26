import java.util.*;

class Solution {

    private ArrayList<Integer> heap = new ArrayList<>();

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap.get(parent) < heap.get(index)) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {

        int size = heap.size();

        while (true) {

            int largest = index;

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    public void initializeHeap() {
        heap.clear();
    }

    public void insert(int key) {

        heap.add(key);

        heapifyUp(heap.size() - 1);
    }

    public void changeKey(int index, int newVal) {

        if (index < 0 || index >= heap.size()) {
            return;
        }

        int oldVal = heap.get(index);

        heap.set(index, newVal);

        if (newVal > oldVal) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    public void extractMax() {

        if (heap.isEmpty()) {
            return;
        }

        int lastIndex = heap.size() - 1;

        heap.set(0, heap.get(lastIndex));

        heap.remove(lastIndex);

        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int getMax() {

        if (heap.isEmpty()) {
            return -1;
        }

        return heap.get(0);
    }

    public int heapSize() {
        return heap.size();
    }
}