
package com.mycompany.laba2;

public class OrkBuilderFactory {
    public OrkBuilder createOrkBuilder(String tribe) {
        switch (tribe) {
            case "Мордор" -> {
                return new MordorOrkBuilder();
            }
            case "Дол Гулдур" -> {
                return new DolGuldurOrkBuilder();
            }
            case "Мглистые Горы" -> {
                return new MistyMountainsOrkBuilder();
            }
            default -> throw new IllegalArgumentException("Такого племени нет");
        }
    }
}
