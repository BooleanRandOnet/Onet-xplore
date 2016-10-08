package booleancorp.onetxplore.classebdd;

public class Joueur {

    private int id;
    private String pseudo;
    private String password;
    private int score;
    private String photo;

    public Joueur(int id, String pseudo, String password, int score, String photo) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.score = score;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", photo='" + photo + '\'' +
                '}';
    }
}