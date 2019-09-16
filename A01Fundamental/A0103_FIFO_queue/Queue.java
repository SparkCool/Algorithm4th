package StandardAlgorithm.A0103_FIFO_queue;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        // 尾插法: 将新入队元素插入到队尾
        // 主要是队尾删除元素麻烦
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else{
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;// 当取出的是最后一个元素, 执行完这条语句后, first == null
        if (isEmpty()){
            last = null;// 此时, 需要将last也置为null, 否则last还指向那个元素
        }
        N--;
        return item;
    }
}
