
package com.mycompany.laba2.Banners;

public class LeaderBanner implements Banner{

    private final String description = "Красное знамя лидера"; 
    
    @Override
    public String getDescription() {
        return description;
    }
    
}
