import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        TreeSet<String> dup = new TreeSet<String>();
        int[] kvs = new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,0,7,7,8,8,8,9,9,9,0};
        for(int i = 0; i < n; i++){
            String s = sc.next();
            StringBuffer sb = new StringBuffer("");
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(Character.isDigit(c))sb.append(c);
                else if(c != '-')sb.append((char)(kvs[c-'A'] + '0'));
                if(sb.length() == 3)sb.append('-');
            }
            String tn = sb.toString();
            if(ht.containsKey(tn)){
                int freq = ht.get(tn) + 1;
                ht.put(tn, freq);
                if(freq == 2)dup.add(tn);
            }else{
                ht.put(tn, 1);
            }
        }
        if(dup.size() == 0){
            System.out.println("No duplicates.");
        }else{
            Iterator<String> it = dup.iterator();
            StringBuffer ob = new StringBuffer();
            for(;it.hasNext();){
                String p = it.next();
                //System.out.printf("%s %d\n", p, ht.get(p));
                ob.append(String.format("%s %d\n", p, ht.get(p)));
            }
            System.out.print(ob);
        }
    }
}
