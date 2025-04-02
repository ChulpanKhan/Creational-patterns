
package com.mycompany.laba2;

public class OrkBuilderFactory {
    public OrkBuilder createOrkBuilder(String tribe) {
        switch (tribe) {
            case "Mordor":
                return new MordorOrkBuilder();
            case "Dol Guldur":
                return new DolGuldurOrkBuilder();
            case "Misty Mountains":
                return new MistyMountainsOrkBuilder();
            default:
                throw new IllegalArgumentException("Unknown tribe: " + tribe);
        }
    }
}
