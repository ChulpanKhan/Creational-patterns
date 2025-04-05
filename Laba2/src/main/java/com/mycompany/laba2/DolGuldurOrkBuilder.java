
package com.mycompany.laba2;

import com.mycompany.laba2.GearFactory.DolGuldurGearFactory;

public class DolGuldurOrkBuilder extends OrkBuilder {

    public DolGuldurOrkBuilder() {
        super(new DolGuldurGearFactory());
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
        this.tribe = "Дол Гурдур";
        this.strength = 30 + random.nextInt(71);
        this.agility = 10 + random.nextInt(71);
        this.intelligence = 1 + random.nextInt(50);
        this.health = 50 + random.nextInt(151);
        
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, tribe, role);
    }
    
}
