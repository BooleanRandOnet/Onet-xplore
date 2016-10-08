package booleancorp.onetxplore.classebdd;

public class Itineraire {

    private int id;
    private String nom;
    private String difficulte;

    public Itineraire(int id, String nom, String difficulte) {
        this.id = id;
        this.nom = nom;
        this.difficulte = difficulte;
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

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public String toString() {
        return "Itineraire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", difficulte='" + difficulte + '\'' +
                '}';
    }
}