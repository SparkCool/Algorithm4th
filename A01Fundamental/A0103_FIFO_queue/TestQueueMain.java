package StandardAlgorithm.A0103_FIFO_queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestQueueMain {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                q.enqueue(item);
            }else if (!q.isEmpty()){
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
