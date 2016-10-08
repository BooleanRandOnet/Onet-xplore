package booleancorp.onetxplore.classebdd;

public class LieuxCulturels {

    private int id;
    private String nom;
    private String description;
    private double lattitude;
    private double longitude;

    public LieuxCulturels(int id, String nom, String description, double lattitude, double longitude) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LieuxCulturels{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                '}';
    }
}
