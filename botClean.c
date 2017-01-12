#include<stdio.h>

int defaultM(int posr, int posc) {
    if(posr/2<5/2) {
        return 1;
    }
    else {
        return 0;
    }
}
void next_move(int posr, int posc, char board[5][5]) {
    int cornerCount=0;
    int LoopCount=0;
    int defaultMove = defaultM(posr, posc);
    while(cornerCount<4&&LoopCount<100){
            if(board[posr+1][posc] == 'd') {
                printf("DOWN\n");
                printf("CLEAN\n");
                board[posr+1][posc] = '-';
                posr = posr+1;
            }
            else if(board[posr-1][posc] == 'd') {
                printf("UP\n");
                printf("CLEAN\n");
                board[posr-1][posc] = '-';
                posr = posr-1;
            }
            else if(board[posr][posc+1] == 'd') {
                printf("RIGHT\n");
                printf("CLEAN\n");
                board[posr][posc+1] = '-';
                posc = posc+1;
            }
            else if(board[posr][posc-1] == 'd') {
                printf("LEFT\n");
                printf("CLEAN\n");
                board[posr][posc-1] = '-';
                posc = posc-1;
            }
            else if(posr==0&&posc==0) {
                printf("DOWN\n");
                posr = posr+1;
                cornerCount++;
            }
            else if(posr==4&&posc==0) {
                printf("RIGHT\n");
                posr = posc+1;
                cornerCount++;
            }
            else if(posr==4&&posc==4) {
                printf("UP\n");
                posr = posr-1;
                cornerCount++;
            }
            else if(posr==0&&posc==4) {
                printf("LEFT\n");
                posc = posc-1;
                defaultMove=0;
                cornerCount++;
            }
            else if(defaultMove==1&&posc<=4) {
                if(posc==4) {
                    //defaultMove=0;
                }
                else {
               printf("RIGHT\n");
               posc = posc+1;
            }
        }
            else if(defaultMove==0&&posc>=0) {
                if(posc==0) {
                    //defaultMove=1;
                }
                else {
                posc = posc-1;
                printf("LEFT\n");
                }
            }
            LoopCount++;
    }
}
int main(void) {
    int pos[2], i;
    char board[5][5], line[6];
    scanf("%d", &pos[0]);
    scanf("%d", &pos[1]);
    for(i=0; i<5; i++) {
        scanf("%s[^\\n]%*c", line);
        strncpy(board[i], line, 5);
    }
    next_move(pos[0], pos[1], board);
    return 0;
}
