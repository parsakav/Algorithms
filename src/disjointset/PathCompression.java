package disjointset;


public class PathCompression {
    private int[] id;
    private int[] size;

    public PathCompression(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p) {
        if (p != id[p]) {
            id[p] = root(id[p]);
        }
        return id[p];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    public static void main(String[] args) {
        PathCompression ds = new PathCompression(10);

        System.out.println(ds.connected(2, 3)); // false

        ds.union(2, 3);
        ds.union(3, 4);
        ds.union(4, 5);

        System.out.println(ds.connected(2, 5)); // true

        System.out.println(ds.connected(2, 6)); // false

        ds.union(5, 6);

        System.out.println(ds.connected(2, 6)); // true
    }
}
