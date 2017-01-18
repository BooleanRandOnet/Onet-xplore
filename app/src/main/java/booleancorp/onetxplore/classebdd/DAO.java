package booleancorp.onetxplore.classebdd;

/**
 * Gestion des données
 * Accès base de données
 * (select, update, delete, insert)
 */
public abstract class DAO {
    /**
     * Insère un objet dans la base de données
     * @param data Object à insérer à la BDD
     * @throws Exception En cas d'erreur (BDD inaccessible...)
     */
    public static void insert(Object data) throws Exception {
        throw new Exception("Méthode non implémentée");
    }

    /**
     * Supprime une ligne de la BDD
     * @param data object à supprimer
     * @throws Exception Si erreur de connexion à la BDD
     */
    public static void delete(Object data) throws Exception {
        throw new Exception("Méthode non implémentée");
    }

    /**
     * Met à jour une ligne de la BDD
     * @param data Objet à mettre à jour
     * @throws Exception Erreur de connexion à la BDD
     */
    public static void update(Object data) throws Exception {
        throw new Exception("Méthode non implémentée");
    }

    /**
     * Récupère toutes les lignes d'une table
     * @return Les objets récupérés
     * @throws Exception Erreur de connexion à la BDD
     */
    public static Object[] selectAll() throws Exception {
        throw new Exception("Méthode non implémentée");
    }

    /**
     * Récupère une ligne de la BDD
     * @param id identifiant de la ligne à récupérer
     * @return L'object correspondant à la selection
     * @throws Exception Erreur de connexion à la BDD
     */
    public static Object find(int id) throws Exception {
        throw new Exception("Méthode non implémentée");
    }

    /**
     * Récupère des lignes correspondant à un critère
     * @param critere critere de sélection
     * @return Les lignes selectionnées
     * @throws Exception Erreur de connexion à la BDD
     */
    public static Object[] findAll(int critere) throws Exception {
        throw new Exception("Méthode non implémentée");
    }
}
