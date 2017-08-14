public class Jumping{
    public String ableToGet(int x, int y, int[] jl){
        double dis = sqrt(x*x + y*y);
        double total = dis;
        double mx = dis;
        for(int len : jl){
            total += len;
            mx = max(mx, len);
        }
        return mx * 2 <= total ? "Able" : "Not able";
    }
}