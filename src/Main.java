import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int listSize = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int listMaxValue = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> randomList = createRandomList(listSize, listMaxValue);
        System.out.print("Вот случайный список: ");
        printList(randomList);
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int filterThreshold = scanner.nextInt();

        logger.log("Запускаем фильтрацию");
        List<Integer> filteredList = new Filter(filterThreshold).filterOut(randomList);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        printList(filteredList);
        System.out.println();

        logger.log("Завершаем программу");
    }

    public static List<Integer> createRandomList(int size, int maxValue) {
        List<Integer> randomList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(maxValue));
        }
        return randomList;
    }

    public static <T> void printList(List<T> list) {
        list.stream().forEach(e -> System.out.print(e + " "));
    }
}