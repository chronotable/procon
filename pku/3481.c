typedef struct ci{
int n;
int p;
}ci;
ci l[2000000];
int c,s,a,i,j,k,p;
main() {
for(;scanf("%d",&i),i;) {
if(i==1) {
scanf("%d%d",&k,&p);
for(j=0;j<c&&l[s+j].p>p;j++);
for(a=c++;a>j;a--)l[s+a]=l[s+a-1];
l[s+j].n=k;l[s+j].p=p;
}else if(i==2) {
printf("%d\n",c?l[s].n:0);
if(c)s++,c--;
}else if(i==3) {
printf("%d\n",c?l[s+c-1].n:0);
if(c)c--;
}
}
}
