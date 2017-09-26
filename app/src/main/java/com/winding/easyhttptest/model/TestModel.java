package com.winding.easyhttptest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class TestModel implements Parcelable {

    private String name;
    private int age;
    private String auto;

    public TestModel(String name, int age, String auto) {
        this.name = name;
        this.age = age;
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", auto='" + auto + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.auto);
    }

    public TestModel() {
    }

    protected TestModel(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.auto = in.readString();
    }

    public static final Parcelable.Creator<TestModel> CREATOR = new Parcelable.Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel source) {
            return new TestModel(source);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };
}
