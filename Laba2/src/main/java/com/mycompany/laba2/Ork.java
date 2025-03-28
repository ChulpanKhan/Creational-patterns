/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laba2;

import com.github.javafaker.Faker;

/**
 *
 * @author MyHuawei
 */
public class Ork {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    
    public Ork(String weapon, String armor, String banner) {
        this.name = new Faker().lordOfTheRings().character();
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
    }
}
