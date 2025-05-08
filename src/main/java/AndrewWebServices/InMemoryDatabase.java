package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase extends Database {
    private Map<String, Integer> userData = new HashMap<>();

    public void addUser(String accountName, int password) {
        userData.put(accountName, password);
    }

    @Override
    public int getPassword(String accountName) {
        return userData.getOrDefault(accountName, -1);
    }
}
