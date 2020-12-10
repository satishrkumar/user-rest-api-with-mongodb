package com.ssaa.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userdata")
public class UserModel {

    public static final String SEQUENCE_NAME = "userdata_sequence";

    @Id
    private Long id;

    private String name;

    private String gender;

    private String age;

    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof UserModel)) { return false; }
        final UserModel userModel = (UserModel) o;
        return Objects.equals(getId(), userModel.getId()) &&
                Objects.equals(getName(), userModel.getName()) &&
                Objects.equals(getGender(), userModel.getGender()) &&
                Objects.equals(getAge(), userModel.getAge()) &&
                Objects.equals(getCountry(), userModel.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGender(), getAge(), getCountry());
    }
}
