package pdm.carlos.android.superhero.model;

import com.google.gson.annotations.SerializedName;

public class Connections {
    @SerializedName("groupAffiliation")
    private String groupAffiliation;
    @SerializedName("relatives")
    private String relatives;

    public Connections(String groupAffiliation, String relatives) {
        this.groupAffiliation = groupAffiliation;
        this.relatives = relatives;
    }

    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }
}
