package com.undacity.qinfeng.myappportfolio;

import android.graphics.Color;

/**
 * Created by fengqin on 16/06/2015.
 */
public class App {

    private String name;//for toast
    private String label;//for button
    private int color;//for background color
    private int textColor;

    public App(String name, String label, int color, int textColor) {
        this.name = name;
        this.label = label;
        this.color = color;
        this.textColor = textColor;
    }

    public App(String name, String label, int color) {
       this(name,label,color, Color.BLACK);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
