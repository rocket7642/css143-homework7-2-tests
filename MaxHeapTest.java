import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class MaxHeapTest {

    @Test
    public void MaxLogND(){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("PerformanceNLogN.txt", "UTF-8");
        }
        catch(IOException e){
            System.out.println("error");
        }

        for(int i = 0; i < 50; i++){
            MaxHeap N = new MaxHeap((i+1)* 100000);
            Integer[] holder = new Integer[(i+1)*100000];
            for(int j = 0; j < holder.length; j++){
                holder[j] = j;
            }
            long startTime = System.nanoTime();
            N.MaxHeapLogN(holder);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            writer.println(duration + " " + (i+1)* 100000);
        }
        writer.println();
        writer.close();
    }

    @Test
    public void MaxND(){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("PerformanceN.txt", "UTF-8");
        }
        catch(IOException e){
            System.out.println("error");
        }

        for(int i = 0; i < 50; i++){
            MaxHeap N = new MaxHeap((i+1)* 100000);
            Integer[] holder = new Integer[(i+1)*100000];
            for(int j = 0; j < holder.length; j++){
                holder[j] = j;
            }
            long startTime = System.nanoTime();
            N.MaxHeapN(holder);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            writer.println(duration + " " + (i+1)* 100000);
        }
        writer.println();
        writer.close();
    }

}