package com.ds.algo.javacore;

import javax.print.Doc;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Key {
    String id;

    public Key(String id) {
        this.id = id;
    }

/*
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(id, key.id);
    }
*/

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

public class GC {
    public static void main(String[] args) {
        Dog[] dogArray = new Dog[100];
        Map<Key, String> map = new HashMap<>();
        map.put(new Key("A123"), "Active");

        System.out.println(map.get(new Key("A123")));
        sendAlert("hello");
    }

    static void sendAlert(String message, String...emails){
        System.out.println(message+" <---> ");
        System.out.println(emails.length);
    }
}
