package disjointset;

import java.util.Arrays;

public class PartialPathCompression {
    private int[] id;
    private int[] size;
    public PartialPathCompression(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
        size = new int[N];
        Arrays.fill(size,1);
    }
    public int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];

            p = id[p];
        }
        return p;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        int i=root(p);
        int j=root(q);
        if (i==j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

}
