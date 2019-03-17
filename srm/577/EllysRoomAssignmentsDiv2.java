import java.util.*;
import static java.lang.Math.*;

public class EllysRoomAssignmentsDiv2{
    public double getProbability(String[] ratings){
        String all = "";
        for(int i = 0; i < ratings.length; i++)all += ratings[i];
        String[] parts = all.split(" ");
        int n = parts.length;
        int rooms = n % 20 == 0 ? n / 20 : n / 20 + 1;
        if(rooms == 1)return 1.0;
        int[] rs = new int[n];
        for(int i = 0; i < n; i++)rs[i] = Integer.parseInt(parts[i]);
        final int elly = rs[0];
        Arrays.sort(rs);
        if(rs[n-1] == elly)return 1.0;
        boolean topg = false;
        for(int i = 0; i < rooms; i++)if(rs[n-1-i] == elly)topg = true;
        return topg ? 0 : 1.0/rooms;
    }
}
