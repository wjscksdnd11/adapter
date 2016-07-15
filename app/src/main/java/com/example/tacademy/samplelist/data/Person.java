package com.example.tacademy.samplelist.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class Person  {

    private String name;
    private int age;
    private Drawable photo;
    public Person() {
    }
    public Person(String name, int age, Drawable photo) {
        this.name = name;
        this.age = age;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

        //원래 여기 처리 해줘야함
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable mdrawable) {
        this.photo = mdrawable;
        //여기도 null값 처리 해줘야 함.

    }
}
