package br.com.giovanni;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FakeService{

    private static Map<Integer, String> USERS = new HashMap<>();

    public FakeService(){
        USERS.put(1, "User 1");
        USERS.put(2, "User 2");
        USERS.put(3, "User 3");
    }

    public String findUserById(final Integer id){
        try {
          Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return USERS.get(id);
    }
}