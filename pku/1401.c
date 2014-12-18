#include <stdio.h>

int main() {
	int n, i, j, N, zeros;
	scanf("%d", &n);
	for(i = 0; i < n; i++) {
		scanf("%d", &N);
		zeros = 0;
		for(j = N / 5; j > 0; j /= 5) {
			zeros += j;
		}
		printf("%d\n", zeros);
	}
	return 0;
}