
package com.mycompany.laba2.GearFactory;

import com.mycompany.laba2.Armors.Armor;
import com.mycompany.laba2.Banners.Banner;
import com.mycompany.laba2.Weapons.Weapon;

public interface OrkGearFactory {
    Weapon createWeapon();
    Armor createArmor();
    Banner createBanner();
}
