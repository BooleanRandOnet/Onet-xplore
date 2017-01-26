package booleancorp.onetxplore.classebdd;

/**
 * Created by gcruw on 26/01/2017.
 */

public class EnigmeDAO extends DAO {

    public EnigmeDAO() {
        super();
    }

    @Override
    public void insert(Object data) throws Exception {
        if (data instanceof Enigme) {

        } else {
            throw new IllegalArgumentException("data doit être un object Enigme");
        }
    }

    @Override
    public void delete(Object data) throws Exception {
        if (data instanceof Enigme) {

        } else {
            throw new IllegalArgumentException("data doit être un object Enigme");
        }
    }

    @Override
    public void update(Object data) throws Exception {
        if (data instanceof Enigme) {

        } else {
            throw new IllegalArgumentException("data doit être un object Enigme");
        }
    }

    @Override
    public Object[] selectAll() throws Exception {
        Enigme[] data = new Enigme[2];
        data[0] = new Enigme(0, "Qui est le BD du groupe ?", "guillaume", 100, "question", "", "");
        data[1] = new Enigme(1, "1+1", "2", 100, "question", "", "");
        return data;
    }

    @Override
    public Object find(int id) throws Exception {
        return  new Enigme(1, "1+1", "2", 100, "question", "", "");
    }

    @Override
    public Object[] findAll(int critere) throws Exception {
        Enigme[] data = new Enigme[2];
        data[0] = new Enigme(0, "Qui est le BD du groupe ?", "guillaume", 100, "question", "", "");
        data[1] = new Enigme(1, "1+1", "2", 100, "question", "", "");
        return data;
    }
}
