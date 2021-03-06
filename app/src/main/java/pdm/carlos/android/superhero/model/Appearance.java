package pdm.carlos.android.superhero.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Appearance {
    @SerializedName("gender")
    private String gender;
    @SerializedName("race")
    private String race;
    @SerializedName("height")
    private List<String> height;
    @SerializedName("weight")
    private List<String> weight;
    @SerializedName("eyeColor")
    private String eyeColor;
    @SerializedName("hairColor")
    private String hairColor;

    public Appearance(String gender, String race, List<String> height, List<String> weight, String eyeColor, String hairColor) {
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public List<String> getHeight() {
        return height;
    }

    public void setHeight(List<String> height) {
        this.height = height;
    }

    public List<String> getWeight() {
        return weight;
    }

    public void setWeight(List<String> weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}
