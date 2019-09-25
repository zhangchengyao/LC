public class LC779_KthSymbolInGrammar {
    public int kthGrammar(int N, int K) {
        if(N == 1) return 0;

        int parent = kthGrammar(N - 1, (K + 1) / 2);
        if((K & 1) == 1) return parent;
        else return parent ^ 1;
    }
}
