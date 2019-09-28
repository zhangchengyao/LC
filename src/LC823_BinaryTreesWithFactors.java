import java.util.*;

public class LC823_BinaryTreesWithFactors {
//    public int numFactoredBinaryTrees(int[] A) {
//        Arrays.sort(A);
//        long[] opts = new long[A.length];
//        Arrays.fill(opts, 1);
//
//        long res = 1;
//        for(int i = 1; i < A.length; i++) {
//            for(int j = 0; j < i; j++) {
//                if(A[i] % A[j] == 0) {
//                    int factor = A[i] / A[j];
//                    int idx = Arrays.binarySearch(A, factor);
//                    if(idx >= 0) {
//                        opts[i] += opts[j] * opts[idx] % mod;
//                    }
//                }
//            }
//
//            res += opts[i];
//            res %= mod;
//        }
//
//        return (int)res;
//    }

    private int mod = 1000000007;
    private Map<Integer, Integer> memo = new HashMap<>();

    public int numFactoredBinaryTrees(int[] A) {
        Map<Integer, Set<Integer>> factorMap = new HashMap<>();
        for(int a: A) {
            factorMap.put(a, new HashSet<>());
            for(int f: A) {
                if(a == f) continue;
                if(a % f == 0) factorMap.get(a).add(f);
            }
        }

        int res = 0;
        for(int root: factorMap.keySet()) {
            res += makeBinaryTrees(root, factorMap);
            res %= mod;
        }

        return res;
    }

    private long makeBinaryTrees(int root, Map<Integer, Set<Integer>> factorMap) {
        if(memo.containsKey(root)) return memo.get(root);

        Set<Integer> factors = factorMap.get(root);

        if(factors.isEmpty()) return 1;

        long res = 1;
        for(int fac: factors) {
            int another = root / fac;
            if(factors.contains(another)) {
                res += makeBinaryTrees(fac, factorMap) * makeBinaryTrees(another, factorMap) % mod;
                res %= mod;
            }
        }
        memo.put(root, (int)res);

        return res;
    }
}
