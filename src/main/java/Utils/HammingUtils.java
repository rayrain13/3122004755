package Utils;

public class HammingUtils {
    public static int getHammingDistance(int hash1, int hash2) {
        int distance = 0;
        int val = hash1 ^ hash2;
        while (val != 0) {
            ++distance;
            val = val & (val - 1);
        }
        return distance;
    }

    public static double getSimilarity(int hammingDistance) {
        return 1 - (double) hammingDistance / 64;
    }
}
