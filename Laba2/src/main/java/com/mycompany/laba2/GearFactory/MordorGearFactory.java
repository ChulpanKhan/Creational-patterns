
package com.mycompany.laba2.GearFactory;

import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Armors.SteelArmor;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.Banners.RedEyeBanner;
import com.mycompany.laba2.Weapons.HeavySword;
import com.mycompany.laba2.Weapons.Weapon;

public class MordorGearFactory implements OrkGearFactory {

    @Override
    public Weapon createWeapon() { 
        return new HeavySword();
    }        
        
    @Override
    public Armor createArmor() {
        return new SteelArmor();
    }

    @Override
    public Banner createBanner() {
        return new RedEyeBanner();
    }
    
}
