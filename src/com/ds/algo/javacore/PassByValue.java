package com.ds.algo.javacore;

class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }
}

public class PassByValue {
    public static void main(String[] args) {
        Dog myDog = new Dog("Sheru");
        System.out.println("My dogs name before object name change :"+myDog.name);
        modifyDogName(myDog);
        System.out.println("My dogs name after object name change :"+myDog.name);
        modifyByAssigningNewDogObject(myDog);
        System.out.println("My dogs name after assigning new object :"+myDog.name);
    }

    private static void modifyByAssigningNewDogObject(Dog myDog) {
        myDog = new Dog("cherry");
        System.out.println("My dogs name after assigning new object :"+myDog.name);
    }

    private static void modifyDogName(Dog myDog) {
        myDog.name = "moti";
    }
}
