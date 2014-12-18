import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n;
    double[][] s;
    Vector<Integer>[] group;
    int groupNum;
    double sum,min,dis;
    int pos;
    while(true) {
      n = scan.nextInt();
      if(n == 0) break;
      s = new double[n][4];

      for(int i = 0;i < n;i++) {
        for(int j = 0;j < 4;j++) {
          s[i][j] = scan.nextDouble();
        }
      }
      if(n == 1) {
        sum = 0.0;
        System.out.printf("%.3f\n",sum);
        continue;
      }

      group = new Vector[n];
      for(int p = 0;p < n;p++) {
        group[p] = new Vector<Integer>();
      }
      groupNum = 0;

      sum = 0.0;
      for(int i = 0;i < n;i++) {
        int a;
        for(a = 0;a < n;a++) {
          if(group[a].indexOf(i) != -1) break;
        }
        if(a != n) continue;

        min = 100000.0;
        pos = n;
        dis = 0.0;
        int j;
        for(j = 0;j < n;j++) {
          if(j == i) continue;
          dis = Math.sqrt(Math.pow(s[i][0] - s[j][0],2.0) + Math.pow(s[i][1] - s[j][1], 2.0) +
                          Math.pow(s[i][2] - s[j][2],2.0)) - s[i][3] - s[j][3];
          if(min > dis) {
            min = dis;
            pos = j;
          }
        }
        if(min >= 0.0) sum += min;

        for(a = 0;a < groupNum;a++) {
          if(group[a].indexOf(pos) != - 1) {
            group[a].add(i);
            break;
          }
        }
        if(a == groupNum) {
          group[groupNum].add(i);
          group[groupNum].add(pos);
          groupNum++;
        }

      }

      //for(int t = 0;t < groupNum;t++) System.out.println(group[t]);

      while(groupNum != 1) {
        min = 100000.0;
        pos = n;
        dis = 0.0;
        int g = 0;
        for(int i = 1;i < groupNum;i++) {
          for(int j = 0;j < group[0].size();j++) {
            for(int k = 0;k < group[i].size();k++) {
              int p = group[0].get(j);
              int q = group[i].get(k);
              dis = Math.sqrt(Math.pow(s[p][0] - s[q][0],2.0) + Math.pow(s[p][1] - s[q][1], 2.0) +
                              Math.pow(s[p][2] - s[q][2],2.0)) - s[p][3] - s[q][3];
              if(min > dis) {
                min = dis;
                g = i;
              }
            }
          }
        }
        if(min >= 0.0) sum += min;
        group[0].addAll(group[g]);
        for(int i = g;i < groupNum - 1;i++) {
          group[i] = group[i + 1];
        }
        groupNum--;
      }
      System.out.printf("%.3f\n",sum);
    }

  }

}

