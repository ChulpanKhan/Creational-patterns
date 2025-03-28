
package com.mycompany.laba2.GearFactory;

import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Armors.LeatherArmor;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.Banners.MoonBanner;
import com.mycompany.laba2.Weapons.Axe;
import com.mycompany.laba2.Weapons.Weapon;

public class MistyMountainsGearFactory implements OrkGearFactory {

    @Override
    public Weapon createWeapon() {
        return new Axe();                
    }

    @Override
    public Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public Banner createBanner() {
        return new MoonBanner();
    }
    
}
