package StandardAlgorithm.A0104_UnionFind;

public class QuickUnion_UF extends UF {
    private int[] id;
    private int count;
    // 由于父类中使用了有参构造, 子类必须重写
    public QuickUnion_UF(int N) {
        super(N);
    }

    // 重写find
    @Override
    public int find(int p) {
        while(p != id[p]){
            p = id[p]; // 直到指向自己, 到达了根节点
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }else{
            id[pRoot] = qRoot;
            count--;
        }
    }
}
