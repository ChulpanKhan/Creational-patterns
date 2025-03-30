
package com.mycompany.laba2;

import com.github.javafaker.Faker;

public class Ork {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    private String tribe;
    private String role;
    
    public Ork(String name, String weapon, String armor, String banner, 
            int strength, int agility, int intelligence, int health,
            String tribe, String role) {
        //this.name = new Faker().lordOfTheRings().character();
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
        this.tribe = tribe;
        this.role = role;
    }
}
