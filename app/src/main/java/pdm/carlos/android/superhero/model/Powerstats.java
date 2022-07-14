package pdm.carlos.android.superhero.model;

import com.google.gson.annotations.SerializedName;

public class Powerstats {
    @SerializedName("intelligence")
    private Integer intelligence;
    @SerializedName("strength")
    private Integer strength;
    @SerializedName("speed")
    private Integer speed;
    @SerializedName("durability")
    private Integer durability;
    @SerializedName("power")
    private Integer power;
    @SerializedName("combat")
    private Integer combat;

    public Powerstats(Integer intelligence, Integer strength, Integer speed, Integer durability, Integer power, Integer combat) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getCombat() {
        return combat;
    }

    public void setCombat(Integer combat) {
        this.combat = combat;
    }
}
