
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
        return builder
            .setRole("Командир")
            .setBanner(new LeaderBanner()) 
            .build();
    }
    public Ork createScoutOrk(OrkBuilder builder) {
        return builder
            .setRole("Разведчик")
            .setWeapon(new Bow()) 
            .build();
    }
}
