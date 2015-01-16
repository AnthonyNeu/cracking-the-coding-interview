import java.util.ArrayList;

public class Person {
    private int ID;
    private String info;
    public ArrayList<Integer> friends;

    public Person(int ID)
    {
        this.ID = ID;
    }

    public String getinfo(){return info;}

    public void setinfo(String info){this.info = info;}

    public int getID() { return ID; }

    public void addFriend(int id) { friends.add(id); }

    public int[]getfriend()
    {
        int[] temp = new int[friends.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = friends.get(i);
        }
        return temp;
    }
}
