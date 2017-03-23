package booleancorp.onetxplore.metier;

/**
 * TODO
 *
 * @author Maxime BELMON
 * @version 1.0
 */
public class Code implements Activable {

    /** Valeur du code */
    private String id;

    /** State of the code */
    private boolean enabled;

    /** Number of code activable */
    private int nbCode;

    /**
     * Create the code and caclcule nbCode
     * @param id
     * @param enabled
     * @param nbCodeMax
     * @param nbCodeActivate
     */
    public Code(String id, boolean enabled, int nbCodeMax, int nbCodeActivate) {
        this.id = id;
        this.enabled = enabled;
        this.nbCode = nbCodeMax - nbCodeActivate;
    }

    @Override
    public boolean isActive() {
        return enabled;
    }

    @Override
    public void setActivation(boolean activation) {
        enabled = activation;
    }


}
