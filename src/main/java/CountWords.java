import java.io.FileReader;
import java.util.*;

public class CountWords {
    public void counter() {
        try (FileReader reader = new FileReader("./files/words.txt")) {
            char[] buf = new char[256];
            int num;
            while ((num = reader.read(buf)) > 0) {
                if (num < 256) {
                    buf = Arrays.copyOf(buf, num);
                }
            }
            String[] Words = new String(buf).replaceAll(" ", "\n").split(System.lineSeparator());
            Map<String, Integer> map = new HashMap<>();
            for (String item : Words) {
                if (map.containsKey(item)) {
                    map.put(item, map.get(item) + 1);
                } else {
                    map.put(item, 1);
                }
            }
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}