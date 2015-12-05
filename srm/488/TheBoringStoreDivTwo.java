import java.util.*;
import static java.lang.Math.*;

public class TheBoringStoreDivTwo{
    public String find(String J, String B){
        String ret = "";
        int jlen = J.length();
        int blen = B.length();
        for(int a = 0; a < jlen; a++)for(int b = a+1; b <= jlen; b++){
                String ab = J.substring(a, b);
                for(int c = b; c < jlen; c++)for(int d = c+1; d <= jlen; d++){
                        String cd = J.substring(c, d);
                        for(int e = 0; e < blen; e++)for(int f = e+1; f <= blen; f++){
                                String ef = B.substring(e, f);
                                for(int g = f; g < blen; g++)for(int h = g+1; h <= blen; h++){
                                        String gh = B.substring(g, h);
                                        String s = ab + ef;
                                        String t = cd + gh;
                                        if(s.equals(t)){
                                            if(s.length() > ret.length() || (s.length() == ret.length() && ret.compareTo(s) > 0))
                                                ret = s;
                                        }
                                        s = ab + gh;
                                        t = cd + ef;
                                        if(s.equals(t)){
                                            if(s.length() > ret.length() || (s.length() == ret.length() && ret.compareTo(s) > 0))
                                                ret = s;
                                        }
                                    }
                            }
                    }
            }
        return ret;
    }
}
