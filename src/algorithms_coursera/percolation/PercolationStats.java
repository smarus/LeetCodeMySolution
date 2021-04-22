package algorithms_coursera.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int numOfExperiments; // number of experiment carried outs
    private double[] fractions; // an array storing fraction of each percolation

    /**
     * Perform T independent experiments on an N-by-N grid
     */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N <= 0 or T <= 0");
        }
        numOfExperiments = T;
        fractions = new double[numOfExperiments];
        for (int expNum = 0; expNum < numOfExperiments; expNum++) {
            Percolation pr = new Percolation(N);
            int openedSite = 0;
            while (!pr.percolates()) {
                int row = StdRandom.uniform(1, N + 1);
                int col = StdRandom.uniform(1, N + 1);
                if (!pr.isOpen(row, col)) {
                    pr.open(row, col);
                    openedSite++;
                }
            }
            double fraction = (double) openedSite / (N * N);
            fractions[expNum] = fraction;
        }
    }

//    public int numberOfOpenSites(){
//
//    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats pStats = new PercolationStats(N, T);

        String confidence = pStats.confidenceLo() + ", "
                + pStats.confidenceHi();
        StdOut.println("mean                    = " + pStats.mean());
        StdOut.println("stddev                  = " + pStats.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }

    /**
     * Sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(fractions);
    }

    /**
     * Sample standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    /**
     * Low endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(numOfExperiments));
    }

    /**
     * High endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(numOfExperiments));

    }
}
