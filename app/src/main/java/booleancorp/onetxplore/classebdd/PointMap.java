package booleancorp.onetxplore.classebdd;

public class PointMap {

    private int id;
    private String designation;
    private double lattitude;
    private double longitude;

    public PointMap(int id, String designation, double lattitude, double longitude) {
        this.id = id;
        this.designation = designation;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
        return "PointMap{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                '}';
    }
}