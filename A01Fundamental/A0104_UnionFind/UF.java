package StandardAlgorithm.A0104_UnionFind;

/*
* 基本操作:
* 初始化, 连接两个触点, 判断包含某个触点的分量,
* 判断两个触点是否在同一个分量之中, 返回所有分量的数量
*
*
* */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;  // 分量id(以触点作为索引)
    private int count;

    // 构造方法
    public UF(int N) {
        count = N;
        id = new int[N];  // 注意不要写成int[] id = new int[N] 这样相当于创建了一个局部的数组变量
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)  == find(q);
    }

    // 实现1
    public int find(int p){
        return id[p];
    }

    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pId){
                id[i] = qId;
            }
        }
        count--;  // 创建连接后, 连通分量数减1
    }

    // 测试用例
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);  // 创建UF对象
        // 读取在控制台输入的连接对
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)){
                continue;
            }else{
                uf.union(p, q);
            }
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + "components");
    }
}
