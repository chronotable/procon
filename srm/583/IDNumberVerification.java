import java.util.*;
import java.text.*;
import static java.lang.Math.*;

public class IDNumberVerification{
    public String verify(String id, String[] rcs){
        final String NG = "Invalid";
        String region = id.substring(0, 6);
        String birth = id.substring(6, 14);
        String seq = id.substring(14, 17);
        char cs = id.charAt(17);
        // region code
        boolean ok = false;
        for(String r : rcs)if(region.equals(r)){ok = true;}
        if(!ok)return NG;
        // birth
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        try{
            format.setLenient(false);
            format.parse(birth);
        }catch(ParseException e){
            return NG;
        }
        int year = Integer.parseInt(birth.substring(0, 4));
        if(year < 1900 || year > 2011)return NG;
        // check sum
        int val = (cs == 'X' ? 10 : (int)(cs - '0'));
        for(int i = 0; i < 17; i++)val = (val + (int)(id.charAt(i) - '0') * (1 << (17-i))) % 11;
        if(val != 1)return NG;
    
        int s = Integer.parseInt(seq);
        if(s == 0)return NG;
        return s % 2 == 1 ? "Male" : "Female";
    }
  
    private boolean leap(int year){
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))return true;
        else return false;
    }
}
