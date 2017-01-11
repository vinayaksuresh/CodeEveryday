#include <stdio.h>
#include <string.h>
#include <math.h>
void nextMove(int n, int r, int c, char grid[101][101]){
    //logic here
    int botRow = r;
    int botCol = c;
    int princessRow, princessCol;

    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            if(grid[i][j]=='p') {
                princessRow = i;
                princessCol = j;
        }
      }
    }

    if(botRow<princessRow) {
        printf("DOWN");
    }
    else if(botRow>princessRow) {
        printf("UP");
    }
    else if(botCol<princessCol) {
        printf("RIGHT");
    }
    else if(botCol>princessCol) {
        printf("LEFT");
    }

}
int main(void) {

    int n, r, c;

    scanf("%d", &n);
    scanf("%d", &r);
    scanf("%d", &c);

   char grid[101][101];

    for(int i=0; i<n; i++) {
        scanf("%s[^\n]%*c", grid[i]);
    }

    nextMove(n, r, c, grid);
    return 0;
}
