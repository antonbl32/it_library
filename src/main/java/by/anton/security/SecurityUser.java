package by.anton.security;

import by.anton.entity.User;
import by.anton.service.UserService;
import by.anton.service.UserServiceImpl;

import java.beans.PropertyVetoException;
import java.util.*;

public class SecurityUser {
    private UserService userService=new UserServiceImpl();
    public SecurityUser() throws PropertyVetoException {
    }
    private static Map<User, Integer> authorization = new HashMap<>();
    public void authentication() {
        Random random = new Random();
        List<User> list = userService.getAllUsers();
        Scanner sc = new Scanner(System.in);
        int key;
        System.out.println("-------Sign in---------");
        System.out.println("-------Enter your user name - test");
        String name = sc.next();
        System.out.println("-------Enter your password - test");
        String password = sc.next();
        Optional<User> user = list.stream().filter(u -> u.getName().equalsIgnoreCase(name)
                && u.getPassword().equalsIgnoreCase(password)).findFirst();
        if(user.isPresent()){
            key= random.nextInt(10);
            authorization.put(user.get(), key);
            System.out.println("Your auth key is "+ key);
        }else{
            System.out.println("User not found");
        }
    }
    public boolean authorization(int auth){
        Optional<Map.Entry<User,Integer>> myUser=authorization.entrySet().stream().filter(
                entry-> entry.getValue().equals(auth)).findFirst();
        if(myUser.isPresent()){
            return true;
        }
        return false;
    }
}
