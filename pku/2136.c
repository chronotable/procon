s[26],c,m,i,f,l;
main(){
  for(;l<4;){
    c=getchar();
    if(c>='A'&&c<='Z'){
      s[c-'A']++;
      if(s[c-'A']>m)m=s[c-'A'];
    }else if(c=='\n')l++;
  }
  for(;m>0;m--,putchar('\n'))
    for(c=0;c<26;c++){
      putchar(s[c]>=m?'*':' ');
      for(f=i=c+1;i<26;i++){
        if(s[i]>=m)f=0;
      }
      if(f)break;
      if(c<25)putchar(' ');
    }
  for(c=0;c<25;c++)putchar(c+'A'),putchar(' ');
  putchar('Z');
  putchar('\n');
}
