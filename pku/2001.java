import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    Node root;
    char[][] c = new char[1001][21];
    int[] len = new int[1001];
    int n = 0;

    void trie(){
        root = new Node();
        for(int i = 0; i < 26;i++)root.child[i] = null;
    }
    void insert(int k){
        Node r = root, p;
        for(int i = 0; i < len[k];i++){
            if(r.child[c[k][i]-'a'] == null){
                p = new Node();
                for(int j = 0; j < 26;j++)p.child[j] = null;
                r.child[c[k][i]-'a'] = p;
            }
            r = r.child[c[k][i] - 'a'];
            r.count++;
        }
    }
    String search(int k){
        Node r = root;
        String res = "";
        for(int i = 0; i < len[k];i++){
            r = r.child[c[k][i] - 'a'];
            res += c[k][i];
            if(r.count==1)return res;
        }
        return res;
    }

    void run(){
        trie();
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            String s = sc.next();
            len[n] = s.length();
            for(int i = 0; i < len[n];i++)c[n][i] = s.charAt(i);
            insert(n);
            n++;
        }
        for(int i = 0; i < n;i++){
            String s = "";
            for(int j = 0; j < len[i];j++)s += c[i][j];
            System.out.println(s + " " + search(i));
        }
    }
}

class Node{
    Node[] child = new Node[26];
    int count;
    Node(){
        count = 0;
    }
}