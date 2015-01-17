import java.util.Comparator;
import java.util.Arrays;

public class AnagramComparator implements Comparator<String> {
    public String sort(String s)
    {
        char[]str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }

    public int compare(String s1,String s2)
    {
        return sort(s1).compareTo(sort(s2));
    }
}
