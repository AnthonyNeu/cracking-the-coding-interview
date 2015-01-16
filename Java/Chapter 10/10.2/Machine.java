import java.util.HashMap;

public class Machine {
    public HashMap<Integer,Person> persons = new HashMap<Integer, Person>();
    public int machineID;

    public Person getpersonWithID(int id)
    {
        return persons.get(id);
    }
}
