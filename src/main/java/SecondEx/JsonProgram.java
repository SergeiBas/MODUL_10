package SecondEx;
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
    public void createArrayFromFile() {
        try (FileReader reader = new FileReader("./files/json.txt")) {
            char[] buffer = new char[256];
            int c;
            while ((c = reader.read(buffer)) > 0) {
                if (c < 256) {
                    buffer = Arrays.copyOf(buffer, c);
                }
            }
            String[] arrElem = new String(buffer).replaceAll(" ", "\n").split(System.lineSeparator());
            List<String> names = new ArrayList();
            List<Integer> ages = new ArrayList();
            for (String elem : arrElem) {
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
                file.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        JsonProgram jsonProgram = new JsonProgram();
        jsonProgram.createArrayFromFile();
    }
}