
package com.mycompany.laba2;

import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.Weapons.Weapon;

public abstract class OrkBuilder implements OrkBuilderFactory{
    OrkBuilder setName(String name);
    OrkBuilder setWeapon(Weapon weapon);
    OrkBuilder setArmor(Armor armor);
    OrkBuilder setBanner(Banner banner);
    OrkBuilder setStrength(int strength);
    OrkBuilder setAgility(int agility);
    OrkBuilder setIntelligence(int intelligence);
    OrkBuilder setHealth(int health);
    OrkBuilder setTribe(String tribe);
    OrkBuilder setRole(String role);
    Ork build();

}
