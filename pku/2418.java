import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        int tot = 0;
        for(;sc.hasNext();){
            String s = sc.nextLine();
            if(!ht.containsKey(s))ht.put(s,1);
            else ht.put(s, ht.get(s)+1);
            tot++;
        }
        Enumeration<String> en = ht.keys();
        String[] tbl = new String[ht.size()];
        for(int i = 0; i < tbl.length;i++)tbl[i] = en.nextElement();
        Arrays.sort(tbl);
        for(int i = 0; i < tbl.length;i++){
            System.out.printf("%s %.4f\n",tbl[i], 100.0 * ht.get(tbl[i]) / tot);
        }
    }
}
