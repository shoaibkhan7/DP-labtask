package com.mycompany.main;

interface IPerson {
    String getName();
}

class Villager implements IPerson {
    @Override
    public String getName() {
        return "Village Person";
    }
}

class CityPerson implements IPerson {
    @Override
    public String getName() {
        return "City Person";
    }
}

enum PersonType {
    Rural,
    Urban
}

class PersonFactory {
    public IPerson getPerson(PersonType type) {
        switch (type) {
            case Rural -> {
                return new Villager();
            }
            case Urban -> {
                return new CityPerson();
            }
            default -> throw new IllegalArgumentException("Unsupported PersonType");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();
        
        IPerson ruralPerson = factory.getPerson(PersonType.Rural);
        System.out.println(ruralPerson.getName()); 
        
        IPerson urbanPerson = factory.getPerson(PersonType.Urban);
        System.out.println(urbanPerson.getName()); 
    }
}

