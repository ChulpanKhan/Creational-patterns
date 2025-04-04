
package com.mycompany.laba2;

import com.mycompany.laba2.GearFactory.*;

public class MistyMountainsOrkBuilder extends OrkBuilder {

    public MistyMountainsOrkBuilder() {
        super(new MistyMountainsGearFactory());
    }


    @Override
    public Ork build() {
        this.weapon = gearFactory.createWeapon();
        this.armor = gearFactory.createArmor();
        this.banner = gearFactory.createBanner();
        this.tribe = "Мглистые горы";
        this.strength = 30 + random.nextInt(71);
        this.agility = (int)(10 + random.nextInt(91) * 1.3); // +30% к ловкости
        this.intelligence = 1 + random.nextInt(30); // Пониженный интеллект
        this.health = 50 + random.nextInt(151);
        
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, tribe, role);
    }
    
}
