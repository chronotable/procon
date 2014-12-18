import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	BufferedReader sc = new
	    BufferedReader(new InputStreamReader(System.in));
	for(;;){
	    try{
		String line = sc.readLine();
		int n = Integer.parseInt(line.split(" ")[0]);
		int m = Integer.parseInt(line.split(" ")[1]);
		if(n+m == 0)return;
		Hashtable<String, Integer> ht =
		    new Hashtable<String, Integer>();
		for(int i = 0; i < n; i++){
		    line = sc.readLine();
		    if(ht.containsKey(line)){
			ht.put(line, ht.get(line)+1);
		    }else{
			ht.put(line, 1);
		    }
		}
		Enumeration<String> keys = ht.keys();
		int[] freq = new int[n];
		for(;keys.hasMoreElements();){
		    String k = keys.nextElement();
		    freq[ht.get(k)-1]++;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < freq.length; i++){
		    sb.append(freq[i] + "\n");
		}
		System.out.print(sb);
	    }catch(Exception e){
		e.printStackTrace();
	    }
	}
    }
}