package pdm.carlos.android.superhero.model;

import com.google.gson.annotations.SerializedName;

public class Images {
    @SerializedName("xs")
    private String xs;
    @SerializedName("sm")
    private String sm;
    @SerializedName("md")
    private String md;
    @SerializedName("lg")
    private String lg;

    public Images(String xs, String sm, String md, String lg) {
        this.xs = xs;
        this.sm = sm;
        this.md = md;
        this.lg = lg;
    }

    public String getXs() {
        return xs;
    }

    public void setXs(String xs) {
        this.xs = xs;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }
}
