
package com.mycompany.laba2;

import com.github.javafaker.Faker;
import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.GearFactory.OrkGearFactory;
import com.mycompany.laba2.Weapons.Weapon;
import java.util.Random;

public abstract class OrkBuilder {
    protected String name;
    protected Weapon weapon;
    protected Armor armor;
    protected Banner banner;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;
    protected String tribe;
    protected String role;
    protected final Faker faker = new Faker();
    protected final Random random = new Random();
    protected final OrkGearFactory gearFactory; 
    
    public OrkBuilder(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }
    
    public OrkBuilder setName(String name) {
        this.name = faker.lordOfTheRings().character();
        return this;
    }
    
    public OrkBuilder setRole(String role) {
        this.role = role;
        return this;
    }

        public OrkBuilder setWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
    }

    public OrkBuilder setArmor(Armor armor) {
        this.armor = armor;
        return this;
    }

    public OrkBuilder setBanner(Banner banner) {
        this.banner = banner;
        return this;
    }
    
    public abstract Ork build();
}
