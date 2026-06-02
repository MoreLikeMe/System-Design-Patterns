package design.lld.splitwise.service;

import design.lld.splitwise.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final static Map<String, User> users = new HashMap<>();

    public User createUser(String mobNo, String name){
        if(users.containsKey(mobNo)){
            System.out.println("Mobile No already exists");
            return null;
        }
        User user = new User(mobNo, name);
        users.put(mobNo, user);
        return user;
    }

    public User getUser(String mobNo){
        if(!users.containsKey(mobNo)){
            System.out.println("Mobile No doesnot exist");
        }
        return users.get(mobNo);
    }

}
