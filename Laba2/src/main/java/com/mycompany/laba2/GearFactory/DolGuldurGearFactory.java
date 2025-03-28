
package com.mycompany.laba2.GearFactory;

import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Armors.ChainMail;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.Banners.SpiderBanner;
import com.mycompany.laba2.Weapons.Spear;
import com.mycompany.laba2.Weapons.Weapon;


public class DolGuldurGearFactory implements OrkGearFactory {

    @Override
    public Weapon createWeapon() {
        return new Spear();
    }

    @Override
    public Armor createArmor() {
        return new ChainMail();
    }

    @Override
    public Banner createBanner() {
        return new SpiderBanner();
    }
    
}
