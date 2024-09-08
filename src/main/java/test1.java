import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.BaseAnalysis;

public class test1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String text = "20个左边的卡罗拉倒车镜! ";
        Result analysisedResult = BaseAnalysis.parse(text);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("基本分词: " + analysisedResult + "(" + time + "ms)");
    }
}
