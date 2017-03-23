package booleancorp.onetxplore.metier;

import java.sql.Timestamp;

/**
 * Class to handle duration
 * @author Maxime BELMON
 * @version 1.0
 */
public class Duration {

    /** Date de début */
    private Timestamp dateStart;

    /** Date de fin */
    private Timestamp dateEnd;

    /**
     * Constructeur par défaut
     * @param dateStart - Date de début
     * @param dateEnd - Date de fin
     */
    public Duration(Timestamp dateStart, Timestamp dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    /**
     * Constructor with duration
     * @param dateStart - Date de début
     * @param duration - Durée
     */
    public Duration(Timestamp dateStart,int duration) {
        this.dateStart = dateStart;
        dateEnd.setTime(dateStart.getTime() + duration);
    }

    /**
     * @return Time elapsed since dateStart
     */
    public int getElapsedTime() {
        return (int)(System.currentTimeMillis() - dateStart.getTime());
    }

    /**
     * @return Remaining time before dateEnd
     */
    public int getRemainingTime() {
        return (int)(dateEnd.getTime() - System.currentTimeMillis());
    }

    /**
     * @return dateStart
     */
    public Timestamp getDateStart() {
        return dateStart;
    }

    /**
     * @return dateEnd
     */
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    /**
     * Change the date of start
     * @param dateStart - New date of start
     */
    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * Change the date of end
     * @param dateEnd - New date of end
     */
    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }
}
