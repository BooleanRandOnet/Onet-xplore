package booleancorp.onetxplore.metier;

/**
 * TODO
 *
 * @author Maxime BELMON
 * @version 1.0
 */
public interface Activable {

    /**
     * @return State of the object
     */
    boolean isActive();

    /**
     * Define the new state of the object
     * @param activation - New value of the object
     */
    void setActivation(boolean activation);
}
