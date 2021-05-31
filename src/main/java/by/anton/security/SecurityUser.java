package by.anton.security;

import by.anton.entity.User;
import by.anton.service.UserService;
import by.anton.service.UserServiceImpl;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SecurityUser {
    private final UserService userService = new UserServiceImpl();

    public SecurityUser() throws PropertyVetoException {
    }

    private static Map<User, String> authorization = new HashMap<>();

    public void authentication() {
        List<User> list = userService.getAllUsers();
        Scanner sc = new Scanner(System.in);
        String key;
        System.out.println("-------Sign in---------");
        System.out.println("-------Enter your user name - test");
        String name = sc.next();
        System.out.println("-------Enter your password - test");
        String password = sc.next();
        Optional<User> user = list.stream().filter(u -> u.getName().equalsIgnoreCase(name)
                && u.getPassword().equalsIgnoreCase(password)).findFirst();
        if (user.isPresent()) {
            key = getUUID();
            authorization.put(user.get(), key);
        } else {
            System.out.println("User not found");
        }
    }

    public boolean authorization(String auth) {
        Optional<Map.Entry<User, String>> myUser = authorization.entrySet().stream().filter(
                entry -> entry.getValue().equals(auth)).findFirst();
        return myUser.isPresent();
    }

    public boolean getRole() {
        boolean auth = false;
        do {
            if (authorization(getUUID())) {
                return true;
            } else {
                System.out.println("Авторизуйтесь!");
                authentication();
            }
        } while (!auth);
        return false;
    }
    public User getUserByUUID(){
        Optional<Map.Entry<User, String>> myUser = authorization.entrySet().stream().filter(
                entry -> entry.getValue().equals(getUUID())).findFirst();
        return myUser.get().getKey();
    }
    public String getUUID() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            StringBuffer output = new StringBuffer();
            Process process;
            String[] cmd = {"wmic", "csproduct", "get", "UUID"};
            try {
                process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return output.toString();
        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
            StringBuffer output = new StringBuffer();
            Process process;
            String[] cmd = {"/bin/sh", "-c", "echo <password for superuser> | sudo -S cat /sys/class/dmi/id/product_uuid"};
            try {
                process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return output.toString();
        }
        return null;
    }
}
