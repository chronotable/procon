#include <iostream>
#include <string>
#include <cstdio>
#include <cmath>
using namespace std;
#define EPS 1.0e-6

struct Point {
    double x,y;
};

int dblcmp(double r) {
    if(fabs(r)<EPS) return 0;
    return r>0?1:-1;
}

double dot(double x1,double y1,double x2,double y2) {
    return x1*y2-x2*y1;
}

double cross(Point a,Point b,Point c) {
    return dot(b.x-a.x,b.y-a.y,c.x-a.x,c.y-a.y);
}
bool lineseg(Point a,Point b,Point c,Point d) {
    return (((dblcmp(cross(a,b,c))^dblcmp(cross(a,b,d)))==-2)
                &&((dblcmp(cross(c,d,a))^dblcmp(cross(c,d,b)))==-2));
}
double mydist(Point a,Point b) {
    return sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
}

double g[200][200];
int s,t;
int n;
Point line[200][2];
Point pts[200];

int main() {
    double x,y1,y2,y3,y4;
    while(cin>>n) {
        if(n==-1) break;
        s=0,t=4*n+1;
        pts[0].x=0;
        pts[0].y=5;
        pts[t].x=10;
        pts[t].y=5;

        for(int i=0;i<n;i++) {
            cin>>x>>y1>>y2>>y3>>y4;
        
            line[i*3][0].x=x;
            line[i*3][0].y=0;
            line[i*3][1].x=x;
            line[i*3][1].y=y1;

            line[i*3+1][0].x=x;
            line[i*3+1][0].y=y2;
            line[i*3+1][1].x=x;
            line[i*3+1][1].y=y3;

            line[i*3+2][0].x=x;
            line[i*3+2][0].y=y4;
            line[i*3+2][1].x=x;
            line[i*3+2][1].y=10;

            pts[4*i+1].x=x;
            pts[4*i+1].y=y1;
            pts[4*i+2].x=x;
            pts[4*i+2].y=y2;
            pts[4*i+3].x=x;
            pts[4*i+3].y=y3;
            pts[4*i+4].x=x;
            pts[4*i+4].y=y4;
        }
        for(int i=s;i<=t;i++)
            for(int j=s;j<=t;j++)
                g[i][j]=1.0e10;
        //下面建图
        for(int i=0;i<=t;i++) {
            for(int j=i+1;j<=t;j++) {
                bool ok=true;
                for(int k=0;k<3*n;k++) {
                    if(pts[i].x!=pts[j].x&&pts[i].x!=line[k][0].x&&pts[j].x!=line[k][0].x&&lineseg(pts[i],pts[j],line[k][0],line[k][1])) {
                        ok=false;
                        break;
                    }
                }
                if(ok) {
                    g[i][j]=mydist(pts[i],pts[j]);
                }
            }
        }

        //下面用Dijkstra算法求最短路
        double dist[200];
        for(int i=s;i<=t;i++) dist[i]=1.0e10;
        dist[0]=0;
        bool vis[200];
        memset(vis,false,sizeof(vis));
        for(int i=s;i<=t;i++) {
            double mind=1.0e10;
            int id;
            for(int j=s;j<=t;j++) {
                if(!vis[j]&&mind>dist[j]) {
                    id=j;
                    mind=dist[j];
                }
            }
            if(mind==1.0e10) break;
            vis[id]=true;
            for(int j=s;j<=t;j++) {
                if(!vis[j]&&dist[id]+g[id][j]<dist[j]) {
                    dist[j]=dist[id]+g[id][j];
                }
            }
        }

        printf("%.2f\n",dist[t]);
    }
    return 0;
}
