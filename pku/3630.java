import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    Trie root;

    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt();o>0;o--){
            int n = sc.nextInt();
            MyStr[] pn = new MyStr[n];
            for(int i = 0; i < n;i++)pn[i] = new MyStr(sc.next());
            Arrays.sort(pn);
            root = new Trie();
            boolean flag = true;
            for(int i = 0; i < n && flag;i++){
                flag = flag && tra(pn[i].s, 0, root);
            }
            System.out.printf("%s\n", flag ? "YES" : "NO");
        }
    }

    boolean tra(String r, int cur, Trie node){
        if(node.end)
            return false;
        if(r.length() == cur){
            node.end = true;
            return true;
        }
        int v = r.charAt(cur) - '0';
        if(node.child[v] == null)
            node.child[v] = new Trie();
        return tra(r, cur+1, node.child[v]);
    }

    class Trie{
        boolean end;
        Trie[] child;
        Trie(){
            end = false;
            child = new Trie[10];
            Arrays.fill(child, null);
        }
    }

    class MyStr implements Comparable<MyStr>{
        String s;
        MyStr(String t){
            s=t;
        }
        public int compareTo(MyStr m){
            return this.s.length() - m.s.length();
        }
    }
}
