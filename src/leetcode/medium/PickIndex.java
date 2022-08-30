package leetcode.medium;

class PickIndex {

    int weight[];
    int prefixSum = 0;

    public PickIndex(int[] w) {
        weight = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            weight[i] = prefixSum;
        }


    }

    public int pickIndex() {
        double weightValue = Math.random() * prefixSum;
        int left = 0;
        int right = weight.length - 1;
        int pickedIndex = weight.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (weight[mid] <= weightValue) {
                left = mid + 1;
            } else {
                pickedIndex = right;
                right = mid - 1;
            }
        }

        return pickedIndex;
    }
}