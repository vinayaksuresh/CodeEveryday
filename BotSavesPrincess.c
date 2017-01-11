#include <stdio.h>
#include <string.h>
#include <math.h>
void displayPathtoPrincess(int n, char grid[101][101]){
    //logic here
    int botRow,botCol,princessRow,princessCol;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++) {
            if(grid[i][j]=='m') {
                botRow = i;
                botCol = j;
            }
        else if(grid[i][j]=='p') {
            princessRow = i;
            princessCol = j;
        }
    }
    while(botRow<princessRow) {
        printf("DOWN\n");
        botRow++;
    }
    while(botRow>princessRow) {
        printf("UP\n");
        botRow--;
    }
    while(botCol<princessCol) {
        printf("RIGHT\n");
        botCol++;
    }
    while(botCol>princessCol) {
        printf("LEFT\n");
        botCol--;
    }
}
int main(void) {
    int m;
    scanf("%d", &m);
    char grid[101][101]={};
    char line[101];

    for(int i=0; i<m; i++) {
        scanf("%s", line);
        strcpy(grid[i], line);
    }
    displayPathtoPrincess(m,grid);
    return 0;
}
