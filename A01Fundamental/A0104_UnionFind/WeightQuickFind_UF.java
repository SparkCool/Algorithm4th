package StandardAlgorithm.A0104_UnionFind;

public class WeightQuickFind_UF extends UF {
    private int[] id;
    private int[] sz;  // (有触点索引的)各个根节点所对应的分量的大小
    private int count;


    @Override
    public int find(int p) {
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j){
            return;
        }

        if (sz[i] < sz[j]){
            id[i] = j; sz[j] += sz[i];
        }else{
            id[j] = i; sz[i] += sz[j];
        }
        count--;

    }

    public WeightQuickFind_UF(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = i;
        }



    }
}
