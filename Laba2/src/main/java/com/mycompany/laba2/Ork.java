
package com.mycompany.laba2;

import com.github.javafaker.Faker;
import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.Weapons.Weapon;

public class Ork {
    private String name;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    private String tribe;
    private String role;
    
    public Ork(String name, Weapon weapon, Armor armor, Banner banner, 
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
    
    public String getName() { 
        return name; 
    }
    public Weapon getWeapon() { 
        return weapon; 
    }
    public Armor getArmor() { 
        return armor; 
    }
    public Banner getBanner() { 
        return banner; 
    }
    public int getStrength() { 
        return strength; 
    }
    public int getAgility() { 
        return agility; 
    }
    public int getIntelligence() { 
        return intelligence; 
    }
    public int getHealth() { 
        return health; 
    }
    public String getTribe() { 
        return tribe; 
    }
    public String getRole() { 
        return role; 
    }
    
    @Override
    public String toString() {
        return name;
    }
}
