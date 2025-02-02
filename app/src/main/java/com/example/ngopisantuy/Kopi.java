package com.example.ngopisantuy;

import android.os.Parcel;
import android.os.Parcelable;

public class Kopi implements Parcelable {
    private String name;
    private String detail;
    private int photo;

    public String getName(){
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.detail);
        dest.writeInt(this.photo);
    }

    public Kopi() {
    }

    protected Kopi(Parcel in) {
        this.name = in.readString();
        this.detail = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<Kopi> CREATOR = new Parcelable.Creator<Kopi>() {
        @Override
        public Kopi createFromParcel(Parcel source) {
            return new Kopi(source);
        }

        @Override
        public Kopi[] newArray(int size) {
            return new Kopi[size];
        }
    };
}
