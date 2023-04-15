import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class JsonProgram {
    class UserJson {
        private String name;
        private int age;

        public UserJson(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public void makeArrayFromFile() {
        try (FileReader reader = new FileReader("./files/json.txt")) {
            char[] buf = new char[256];
            int num;
            while ((num = reader.read(buf)) > 0) {
                if (num < 256) {
                    buf = Arrays.copyOf(buf, num);
                }
            }
            String[] arrElements = new String(buf).replaceAll(" ", "\n").split(System.lineSeparator());
            List<String> names = new ArrayList();
            List<Integer> ages = new ArrayList();
            for (String elem : arrElements) {
                if (!elem.equals("name") && !elem.equals("age")) {
                    if (Character.isDigit(elem.charAt(0))) {
                        ages.add(Integer.valueOf(elem));
                    } else {
                        names.add(elem);
                    }
                }
            }

            ArrayList<UserJson> users = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                users.add(new UserJson(names.get(i), ages.get(i)));
            }
            try (FileWriter file = new FileWriter("./files/user.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(users);
                file.write(json);
                file.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}