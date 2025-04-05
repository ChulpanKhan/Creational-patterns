
package com.mycompany.laba2;

import com.mycompany.laba2.GearFactory.*;

public class MistyMountainsOrkBuilder extends OrkBuilder {

    public MistyMountainsOrkBuilder() {
        super(new MistyMountainsGearFactory());
    }


    @Override
    public Ork build() {
        if (this.weapon == null) {
            this.weapon = gearFactory.createWeapon();
        }
        this.armor = gearFactory.createArmor();
        if (this.banner == null) {
            this.banner = gearFactory.createBanner();
        }
        this.tribe = "Мглистые горы";
        this.strength = 30 + random.nextInt(71);
        this.agility = (int)(10 + random.nextInt(91));
        this.intelligence = 1 + random.nextInt(30);
        this.health = 50 + random.nextInt(151);
        
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, tribe, role);
    }
    
}
