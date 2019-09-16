package StandardAlgorithm.A0102_Pushdown_Stack_Linked;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 测试输入
// to be or not to - be - - that - - - is
// 测试输出
// to be not that or be
// ctrl+d  输入EOF退出循环

public class TestStackMain {
    public static void main(String[] args) {

        Stack<String> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            // 如果输入0则弹栈
            if (!str.equals("-")) // 注意: 字符串判断相等不能用==, == 对于抽象类型是比较地址
                s.push(str);
            else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.println("(" + s.size() + " left on stack)");


    }
}
