import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i : source) {
            if (i < threshold) {
                logger.log("Элемент \"" + i + "\" не проходит");
            } else {
                logger.log("Элемент \"" + i + "\" проходит");
                result.add(i);
                count++;
            }
        }
        logger.log("Прошло фильтр " + count + " "
                + getNounDeclensionByNumber(count, "элемент", "элемента", "элементов")
                + " из " + source.size());
        return result;
    }

    private static String getNounDeclensionByNumber(int n, String one, String two, String many) {
        if ((n % 100 / 10) == 1) {
            return many;
        }

        switch (n % 10) {
            case 1:
                return one;
            case 2, 3, 4:
                return two;
            default:
                return many;
        }
    }
}
