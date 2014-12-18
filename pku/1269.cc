#include <iostream>
#include <stdio.h>
using namespace std;   
int main()   
{   
    int N,x1,x2,x3,x4,y1,y2,y3,y4;   
    int a,b,c,d,e,f;   
    scanf("%d",&N);   
    printf("INTERSECTING LINES OUTPUT\n");   
    for(int i=0;i<N;i++)   
    {   
        scanf("%d%d%d%d%d%d%d%d",&x1,&y1,&x2,&y2,&x3,&y3,&x4,&y4);   
        a=y2-y1;   
        b=x2*y1-x1*y2;   
        c=x2-x1;   
        d=y4-y3;   
        e=x4*y3-x3*y4;   
        f=x4-x3;   
        if(a*f==c*d)
        {
            if(b*f==e*c&&b*d==e*a)
            {
                printf("LINE\n");   
                continue;   
            }   
            else  
            {   
                printf("NONE\n");
                continue;
            }
        }
        else
        {   
            double y=((double)(a*e-b*d))/(a*f-c*d);   
            double x=(y*c-b)/a;   
            printf("POINT %.2f %.2f\n",x,y);   
        }   
    }   
    printf("END OF OUTPUT\n");   
    return 0;   
}