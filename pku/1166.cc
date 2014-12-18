#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
using namespace std;   
int map[9][9] = {   
    {1,1,0,1,1,0,0,0,0},   
    {1,1,1,0,0,0,0,0,0},   
    {0,1,1,0,1,1,0,0,0},   
    {1,0,0,1,0,0,1,0,0},   
    {0,1,0,1,1,1,0,1,0},   
    {0,0,1,0,0,1,0,0,1},   
    {0,0,0,1,1,0,1,1,0},   
    {0,0,0,0,0,0,1,1,1},   
    {0,0,0,0,1,1,0,1,1}   
};   
int v[9];   
int main()   
{   
    for(int i = 0; i < 9; ++i)   
        scanf("%d", &v[i]);   
    int a[9];   
    int result[9];   
    for(a[0] = 0; a[0] <= 3; ++a[0])   
        for(a[1] = 0; a[1] <= 3; ++a[1])   
            for(a[2] = 0; a[2] <= 3; ++a[2])   
                for(a[3] = 0; a[3] <= 3; ++a[3])   
                    for(a[4] = 0; a[4] <= 3; ++a[4])   
                        for(a[5] = 0; a[5] <= 3; ++a[5])   
                            for(a[6] = 0; a[6] <= 3; ++a[6])   
                                for(a[7] = 0; a[7] <= 3; ++a[7])   
                                    for(a[8] = 0; a[8] <= 3; ++a[8])   
                                    {   
                                        memset(result, 0, sizeof(result));   
                                        for(int i = 0; i < 9; ++i)   
                                            for(int j = 0; j < 9; ++j)   
                                                result[i] += a[j]*map[j][i];   
                                        bool flag = true;   
                                        for(int i = 0; i < 9; ++i)   
                                            if((result[i] + v[i])%4 != 0)   
                                                flag = false;   
                                        if(flag)   
                                        {   
                                            for(int i = 0; i < a[0]; i++)   
                                                printf("1 ");   
                                            for(int i = 0; i < a[1]; i++)   
                                                printf("2 ");   
                                            for(int i = 0; i < a[2]; i++)   
                                                printf("3 ");   
                                            for(int i = 0; i < a[3]; i++)   
                                                printf("4 ");   
                                            for(int i = 0; i < a[4]; i++)   
                                                printf("5 ");   
                                            for(int i = 0; i < a[5]; i++)   
                                                printf("6 ");   
                                            for(int i = 0; i < a[6]; i++)   
                                                printf("7 ");   
                                            for(int i = 0; i < a[7]; i++)   
                                                printf("8 ");   
                                            for(int i = 0; i < a[8]; i++)   
                                                printf("9 ");   
                                            printf("\n");   
                                            return 0;   
                                        }   
                                    }   
}  
