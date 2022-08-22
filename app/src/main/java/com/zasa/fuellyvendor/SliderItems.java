package com.zasa.fuellyvendor;

public class SliderItems {
    //set to String, if you want to add image url from internet
//    private int image;
//    SliderItems(int image) {
//        this.image = image;
//    }
//    public int getImage() {
//        return image;
//    }

    String name,price;

    public SliderItems(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}