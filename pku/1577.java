import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void insert(Node p, char c){
        if(p.val > c){
            if(p.left != null)insert(p.left, c);
            else p.left = new Node(c);
        }else{
            if(p.right != null)insert(p.right, c);
            else p.right = new Node(c);
        }
    }

    String traverse(Node p){
        if(p == null) return "";
        return "" + p.val + traverse(p.left) + traverse(p.right);
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(boolean f = true;f;){
            ArrayList<String> leaves = new ArrayList<String>();
            for(;;){
                String s = sc.next();
                if(s.equals("*") || s.equals("$")){
                    if(s.equals("$"))f = false;
                    break;
                }
                leaves.add(s);
            }
            Node root = null;
            for(int i = leaves.size()-1; i >= 0; i--){
                String s = leaves.get(i);
                for(int j = 0; j < s.length(); j++){
                    if(root == null)root = new Node(s.charAt(j));
                    else insert(root, s.charAt(j));
                }
            }
            System.out.println(traverse(root));
        }
    }

    class Node{
        Node left, right;
        char val;
        Node(char a){
            val = a;
            left = null;
            right = null;
        }
    }
}
