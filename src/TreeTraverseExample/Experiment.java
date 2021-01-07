package TreeTraverseExample;


import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

public class Experiment {
    public static void main(String[] args) {
        int N = Integer.parseInt(StdIn.readLine());
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Insertion.sort(a);
        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
    }
}
