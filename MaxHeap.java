import java.util.*;
public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] input) {
        Arrays.sort(input);
        for(int i = 0; i < input.length; i++){
            data[input.length-1-i] = input[i];
        }
        size = input.length;
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] input) {
        for(int i = 0; i < input.length; i++){
            data[i] = input[i];
        }
        size = input.length;
        int bottom = parent(size);
        for(int i = bottom; i >= 0; i--){
            swapChain(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {

        data[size] = item;
        moveUp(size);
        size++;
        return true;

    }

    // return the max item in the heap
    public Integer get() {
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        
        int max = data[0];
        data[0] = data[size-1];
        size--;
        swapChain(0);
        return max;
    }

    public static int[] child(int parPos){
        int[] temp = {parPos*2+1,parPos*2+2};
        return temp;
    }

    public static int parent(int chPos){
        return (chPos-1)/2;
    }

    public void swapChain(int pos){
        int largest = pos;
        int[] children = child(pos);
        int left = children[0];
        int right = children[1];

        if (left < size && data[left] > data[largest]){
            largest = left;
        }
        if (right < size && data[right] > data[largest]){
            largest = right; 
        }

        if (largest != pos){ 
            int swap = data[pos]; 
            data[pos] = data[largest]; 
            data[largest] = swap; 

            swapChain(largest); 
        } 
    }


    public void moveUp(int pos){
        int parent = parent(pos);
        if(data[pos] != data[0] && data[parent] < data[pos]){
            int temp = data[parent];
            int temp2 = data[pos];
            data[pos] = temp;
            data[parent] = temp2;
            moveUp(parent);
        }
    }

    public void display(){
        for(int i = 0; i < size; i++){
            System.out.print(data[i]);
        }
    }
}
