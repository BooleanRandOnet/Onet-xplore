package booleancorp.onetxplore.classebdd;

public class Enigme {

    private int id;
    private String enonce;
    private String reponse;
    private int points;
    private String type;
    private String difficulte;
    private String niveauRequis;

    public Enigme(int id, String enonce, String reponse, int points, String type, String difficulte, String niveauRequis) {
        this.id = id;
        this.enonce = enonce;
        this.reponse = reponse;
        this.points = points;
        this.type = type;
        this.difficulte = difficulte;
        this.niveauRequis = niveauRequis;
    }

    public int getId() {
        return id;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public String getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(String niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    @Override
    public String toString() {
        return "Enigme{" +
                "id=" + id +
                ", enonce='" + enonce + '\'' +
                ", reponse='" + reponse + '\'' +
                ", points=" + points +
                ", type='" + type + '\'' +
                ", difficulte='" + difficulte + '\'' +
                ", niveauRequis='" + niveauRequis + '\'' +
                '}';
    }
}