package it.unisa.rubrica;

import android.graphics.drawable.Drawable;

public class Contatto {
    public String name;
    public String surname;
    public String phone;
    public Drawable picture;

    public Contatto(String name, String surname, String phone, Drawable picture) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public Drawable getPicture() {
        return picture;
    }
}
