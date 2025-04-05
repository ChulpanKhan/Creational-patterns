
package com.mycompany.laba2;

import com.mycompany.laba2.GearFactory.MordorGearFactory;

public class MordorOrkBuilder extends OrkBuilder {

    public MordorOrkBuilder() {
        super(new MordorGearFactory());
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
        this.tribe = "Мордор";
        this.strength = 40 + random.nextInt(61);
        this.agility = 10 + random.nextInt(91);
        this.intelligence = 1 + random.nextInt(50);
        this.health = 70 + random.nextInt(131);
        
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, tribe, role);
    }

    
}
