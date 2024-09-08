package Utils;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimHashUtils {
    public static int getHash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * 31 + str.charAt(i)) & 0x7fffffff;
        }
        return hash;
    }

    public static int getSimHash(String str) {
        // 分词
        List<Term> termList = tokenize(str);

        int[] v = new int[64];
        int hash = 0;
        for (Term term : termList) {
            hash = getHash(term.getName());
            for (int i = 0; i < 64; i++) {
                v[i] += (hash & (1 << i)) != 0 ? 1 : -1;
            }
        }

        int simHash = 0;
        for (int i = 0; i < 64; i++) {
            simHash |= (v[i] >= 0 ? 1 : 0) << i;
        }
        return simHash;
    }

    private static List<Term> tokenize(String text) {
        return ToAnalysis.parse(text).getTerms();
    }
}
