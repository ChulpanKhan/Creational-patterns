
package com.mycompany.laba2;

import com.mycompany.laba2.Banners.LeaderBanner;
import com.mycompany.laba2.Weapons.Bow;

public class OrkDirector {
    public Ork createBasicOrk(OrkBuilder builder) {
        return builder
            .setRole("Базовый орк")
            .build();
    }
    public Ork createLeaderOrk(OrkBuilder builder) {
        // Для командира заменяем знамя на специальное и добавляем горн
        return builder
            .setRole("Командир")
            .setBanner(new LeaderBanner()) // Особое знамя
            .build();
    }
    public Ork createScoutOrk(OrkBuilder builder) {
        // Для разведчика заменяем оружие на лук
        return builder
            .setRole("Разведчик")
            .setWeapon(new Bow()) // Лук вместо стандартного оружия
            .build();
    }
}
