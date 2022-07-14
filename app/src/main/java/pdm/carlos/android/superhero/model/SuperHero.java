package pdm.carlos.android.superhero.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SuperHero {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("powerstats")
    private Powerstats powerstats;
    @SerializedName("appearance")
    private Appearance appearance;
    @SerializedName("biography")
    private Biography biography;
    @SerializedName("work")
    private Work work;
    @SerializedName("connections")
    private Connections connections;
    @SerializedName("images")
    private Images images;

    public SuperHero(Integer id, String name, String slug, Powerstats powerstats, Appearance appearance, Biography biography, Work work, Connections connections, Images images) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.powerstats = powerstats;
        this.appearance = appearance;
        this.biography = biography;
        this.work = work;
        this.connections = connections;
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Powerstats getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(Powerstats powerstats) {
        this.powerstats = powerstats;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return Objects.equals(id, superHero.id) && Objects.equals(name, superHero.name) && Objects.equals(slug, superHero.slug) && Objects.equals(powerstats, superHero.powerstats) && Objects.equals(appearance, superHero.appearance) && Objects.equals(biography, superHero.biography) && Objects.equals(work, superHero.work) && Objects.equals(connections, superHero.connections) && Objects.equals(images, superHero.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, powerstats, appearance, biography, work, connections, images);
    }
}
