package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class UsersController {

    private Map<Integer, UserEntity> _users = new HashMap<>()
    {{
        put(1, new UserEntity("jan", 2));
        put(2, new UserEntity("andrzej", 13));
        put(3, new UserEntity("maciek", 20));
    }};

    @RequestMapping("/users")
    @ResponseBody
    public Object Index()
    {
        return _users;
    }

    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object Get(@PathVariable Integer id)
    {
        return _users.get(id);
    }

    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public String Remove(@PathVariable Integer id)
    {
        _users.remove(id);
        return "removed " + id;
    }

    @RequestMapping("/users/add")
    @ResponseBody
    public Object Add(@RequestParam String name, @RequestParam Integer age)
    {
        var newUser = new UserEntity(name, age);
        var id = randInt(100, 999);
        _users.put(id, newUser);
        return id;
    }

    private static int randInt(int min, int max) {
        int randomNum = new Random().nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
