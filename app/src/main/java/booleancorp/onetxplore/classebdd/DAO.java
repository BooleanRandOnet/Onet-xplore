package booleancorp.onetxplore.classebdd;

import java.sql.Connection;

/**
 * Gestion des données
 * Accès base de données
 * (select, update, delete, insert)
 */
public abstract class DAO {

    protected Connection connex;
    /**
     * Initialise la connexion avec la base de données
     */
    public DAO() {
        // TODO récupérer une connexion à la base de données
    }
    /**
     * Insère un objet dans la base de données
     * @param data Object à insérer à la BDD
     * @throws Exception En cas d'erreur (BDD inaccessible...)
     */
    public abstract void insert(Object data) throws Exception;

    /**
     * Supprime une ligne de la BDD
     * @param data object à supprimer
     * @throws Exception Si erreur de connexion à la BDD
     */
    public abstract void delete(Object data) throws Exception;

    /**
     * Met à jour une ligne de la BDD
     * @param data Objet à mettre à jour
     * @throws Exception Erreur de connexion à la BDD
     */
    public abstract void update(Object data) throws Exception;

    /**
     * Récupère toutes les lignes d'une table
     * @return Les objets récupérés
     * @throws Exception Erreur de connexion à la BDD
     */
    public abstract Object[] selectAll() throws Exception;

    /**
     * Récupère une ligne de la BDD
     * @param id identifiant de la ligne à récupérer
     * @return L'object correspondant à la selection
     * @throws Exception Erreur de connexion à la BDD
     */
    public abstract Object find(int id) throws Exception;

    /**
     * Récupère des lignes correspondant à un critère
     * @param critere critere de sélection
     * @return Les lignes selectionnées
     * @throws Exception Erreur de connexion à la BDD
     */
    public abstract Object[] findAll(int critere) throws Exception;
}
