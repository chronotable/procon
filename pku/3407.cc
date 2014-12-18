#include <cmath>
#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>

#include <stdio.h>

using namespace std;

const double PI = acos(-1.0);

struct node{
  double x, y, z;
  double lat, lon;
};

int main(int argc, char* argv[]){
  double lat1, latm1, lon1, lonm1;
  double lat2, latm2, lon2, lonm2;
  node p1, p2;
  char dir1, dir2;
  //printf("%f\n", PI);
  while(scanf("%lf %lf %c %lf %lf %c", &lat1, &latm1, &dir1,
                                  &lon1, &lonm1, &dir2) != EOF){
    p1.lat = (lat1 + latm1 / 60.0) * PI / 180.0;
    p1.lon = (lon1 + lonm1 / 60.0) * PI / 180.0;
    if(dir1 == 'S')p1.lat *= -1;
    if(dir2 == 'W')p1.lon *= -1;
    p1.x = cos(p1.lat) * cos(p1.lon);
    p1.y = cos(p1.lat) * sin(p1.lon);
    p1.z = sin(p1.lat);
    scanf("%lf %lf %c %lf %lf %c", &lat2, &latm2, &dir1,
                              &lon2, &lonm2, &dir2);
    p2.lat = (lat2 + latm2 / 60.0) * PI / 180.0;
    p2.lon = (lon2 + lonm2 / 60.0) * PI / 180.0;
    if(dir1 == 'S')p2.lat *= -1;
    if(dir2 == 'W')p2.lon *= -1;
    p2.x = cos(p2.lat) * cos(p2.lon);
    p2.y = cos(p2.lat) * sin(p2.lon);
    p2.z = sin(p2.lat);
    double angle = acos(p1.x * p2.x + p1.y * p2.y + p1.z * p2.z);
    printf("%.3f\n", angle*6370.0);
  }

  return 0;
}
