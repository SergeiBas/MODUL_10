package ThirdEx;
import java.io.FileReader;
import java.util.*;

public class CountWords {
    public void counter() {
        try (FileReader reader = new FileReader("words.txt")) {
            char[] buffer = new char[256];
            int c;
            while ((c = reader.read(buffer)) > 0) {
                if (c < 256) {
                    buffer = Arrays.copyOf(buffer, c);
                }
            }
            String[] arrWords = new String(buffer).replaceAll(" ", "\n").split(System.lineSeparator());
            Map<String, Integer> map = new HashMap<>();
            for (String i : arrWords) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
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