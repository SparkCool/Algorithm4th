package StandardAlgorithm.A0101_Pushdown_Stack;

import java.util.Iterator;

/*
    算法1.1: 变长数组下压栈
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    // 成员变量
    // 创建对象时指定初始化. 使用Object创建长度为1的数组, 并且强转为Item类型
    private Item[] a = (Item[]) new Object[1];
    private int N;

    // 成员方法
    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    // 调整数组长度, 内部使用, 定义为私有方法
    private void resize(int max){
        // 创建新长度的数组
        Item[] temp = (Item[]) new Object[max];
        // 复制已有数据
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        // 使a重新指向新数组
        a = temp;
    }

    // push方法 压栈之前需要先判断是否需要调整数组长度
    public void push(Item item){
        if (N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    // pop方法
    // 元素弹出后, 将元素的value置为null, 方便JVM垃圾回收, 避免有游离
    // 元素弹出后, 判断是否需要调整数组长度
    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4){
            resize(a.length / 2);
        }
        return item;
    }

    // 迭代器 用于元素遍历
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // 内部类 定义迭代器对象需要的方法
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {

            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            // 一般不用填写内容
        }
    }
}
