
package com.mycompany.laba2;

import com.mycompany.laba2.GearFactory.MordorGearFactory;

public class MordorOrkBuilder extends OrkBuilder {

    public MordorOrkBuilder() {
        super(new MordorGearFactory());
    }



    @Override
    public Ork build() {
        this.weapon = gearFactory.createWeapon();
        this.armor = gearFactory.createArmor();
        this.banner = gearFactory.createBanner();
        this.tribe = "Мордор";
        this.strength = (int)(30 + random.nextInt(71) * 1.3); // +30% к силе
        this.agility = 10 + random.nextInt(91);
        this.intelligence = 1 + random.nextInt(50);
        this.health = 50 + random.nextInt(151);
        
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, tribe, role);
    }

    
}
