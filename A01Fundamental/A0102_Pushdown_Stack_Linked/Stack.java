package StandardAlgorithm.A0102_Pushdown_Stack_Linked;

public class Stack<Item> /*implements Iterable<Item>*/{
    private Node first;  // 默认初始化为null
    private int N;  // 默认初始化为0

    // 节点类, 使用内部类定义
    private class Node{ // 内部类可以直接访问外部的参数, 因此这个类不需要再加泛型
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        // 使用头插法
        // 先将first原来指向的对象保存一下
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        // 取出链表的first
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // public Iterator<Item> iterator()

    // private class ReverseArrayIterator implements Iterator<Item>
}
