/*Question 10.2 How would you design the data structures for a very large social network like Face- book or Linkedin?
Describe how you would design an algorithm to show the connection, or path, between two people (e.g., Me -> Bob -> Susan -> Jason -> You).

 */

import java.util.*;

public class Server {
    HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<Integer, Integer>();

    public Machine getMachineWithId(int machineID) {
        return machines.get(machineID);
    }

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineid = personToMachineMap.get(personID);
        if(machineid == null)
            return null;
        Machine accessMachine = machines.get(machineid);
        if(accessMachine == null)
            return null;
        return accessMachine.getpersonWithID(personID);
    }
}
