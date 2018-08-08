package com.nz.springbootlearning.enumlearn;

public enum Season {
    SPRING("春"),SUMMER("夏"),FALL("秋"),WINTER("冬");
    private String season;


    private Season(String season) {
        this.season = season;
    }

    public String getSeason(){
        return this.season;
    }
}
