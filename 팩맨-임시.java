import java.util.*;
import java.io.*;

public class test{
  public static int[][] board = new int[4][4];
  public static int[][] egg   = new int[4][4];
  public static int[][] dead  = new int[4][4];
  public static int[][] visit = new int[4][4];
  public static int[][] backArr_X = new int[4][4];
  public static int[][] backArr_Y = new int[4][4];

  public static int mCnt;
  public static int pmx, pmy;
  public static int size_X = 4;
  public static int size_Y = 4;

  public static int[] dx = new int[] {-1,0,1,0};
  public static int[] dy = new int[] {0,-1,0,1};
  public static int[] ddx = new int[] {-1,-1,0,1,1,1,0,-1};
  public static int[] ddy = new int[] {0,-1,-1,-1,0,1,1,1};

  public static Queue<int[]> q = new LinkedList<>();
  

  class Monster {
    int x;
    int y;
    public Monster(int x, int y){
      this.x = x;
      this.y = y;
    }
      public boolean isSame(Monster m){
        return this.x == m.x && this.y == m.y;
      }
  }

  public static void copy(boolean eggborn){
    //알이 부화하면서 몬스터보드에 추가된다.
    if(eggborn){
      for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
          board[i][j] += egg[i][j];  
          egg[i][j] = 0;
        }
      }
    } else { //몬스터가 알을 낳는다.
      for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
          egg[i][j] += board[i][j];  
        }
      }
    }
  }

  public static boolean canGo(int x, int y){
    return x>=0 && y>=0 && x<4 && y<4;
  }

  public static int PackManMove(int x, int y){
    int max = -1;
    Queue<int[]> p = new LinkedList<>();
    p.add(new int[] {x,y,0,0,-1,-1,-1});
      
    int b1 = 0;
    int b2 = 0;
    int b3 = 0;
    
    while(!p.isEmpty()){
      int[] pp = p.poll();
      int pdx = pp[0];
      int pdy = pp[1];
      int eat = pp[2];
      int cnt = pp[3];
      int m1 = pp[4];
      int m2 = pp[5];
      int m3 = pp[6];
//큐에 각 이동이력 남기기
     
      if(cnt == 3) {
          if(max<eat){
            max = eat;
            pmx = pdx;
            pmy = pdy;
            b1 = m1;
            b2 = m2;
            b3 = m3;
          }
        continue;
      }
      
cnt ++;
      for(int i=0; i<4; i++){
        int rx = pdx + dx[i];
        int ry = pdy + dy[i];
        if(canGo(rx,ry)){
           switch(cnt){
             case 1: p.add(new int[] {rx,ry,eat+board[rx][ry],cnt,i,-1,-1});
             break;
             case 2: p.add(new int[] {rx,ry,eat+board[rx][ry],cnt,m1,i,-1});
             break;
             case 3: p.add(new int[] {rx,ry,eat+board[rx][ry],cnt,m1,m2,i});
             break;
             default:
               break;
      }
          
        } 
      }

        
    }

      int[] tmx = new int[] {1,0,-1,0};
      int[] tmy = new int[] {0,1,0,-1};
      board[pmx][pmy] = 0;
      dead[pmx][pmy] = 2;
      if(b3 != -1){
        int tx = pmx + tmx[b3];
        int ty = pmy + tmy[b3];
        board[tx][ty] = 0;
        dead[tx][ty] = 2;
        board[tx+tmx[b2]][ty+tmy[b2]] = 0;
        dead[tx+tmx[b2]][ty+tmy[b2]] = 2;

        for(int mrepeat=0; mrepeat<mCnt; mrepeat++){
          int[] qp = q.poll();
          int mdx = qp[0];
          int mdy = qp[1];
          int mddir = qp[2];
          int bady = qp[3];
          if(bady == 1) continue;
          if(mdx==tx && mdy ==ty){
          } else if(mdx == pmx && mdy ==pmy){
          } else if(mdx == (tx+tmx[b2]) && mdy == (ty+tmy[b2])){
          } else {
            q.add(new int[] {mdx,mdy,mddir,0});
          }
        }
        
      }
    mCnt = mCnt - max;
    return max;
  }

  public static void MonsterMove(){
    int mplus = 0;
    for(int mrepeat=0; mrepeat<mCnt; mrepeat++){
      int[] qp = q.poll();
      int mdx = qp[0];
      int mdy = qp[1];
      int mddir = qp[2];
      q.add(new int[] {mdx,mdy,mddir,1});
      mplus++;
      
      for(int i=0; i<8; i++){
        int rmddir = (mddir + i + 8) % 8;
        int rmdx = mdx + ddx[rmddir];
        int rmdy = mdy + ddy[rmddir];
        if(canGo(rmdx,rmdy)){
          if(dead[rmdx][rmdy] == 0){
              if(!(rmdx == pmx && rmdy == pmy)){
              board[mdx][mdy] --;
              board[rmdx][rmdy] ++;
              q.add(new int[] {rmdx,rmdy,i,0});
              break;
            }
          }
        } else if(mdx==rmdx && mdy==rmdy){
          q.add(new int[] {rmdx,rmdy,mddir,0});
        }
      }

    }
  mCnt += mplus;
  }

 public static void deadminus() {
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
       if(dead[i][j]>0) dead[i][j]--; 
    }
  }
 }
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    mCnt = Integer.parseInt(st.nextToken());
    int repeat = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    pmx = Integer.parseInt(st.nextToken()) -1;
    pmy = Integer.parseInt(st.nextToken()) -1;

    for(int i=0; i<mCnt; i++){
      st = new StringTokenizer(br.readLine());
      int mx = Integer.parseInt(st.nextToken()) -1;
      int my = Integer.parseInt(st.nextToken()) -1;
      int mdir = Integer.parseInt(st.nextToken()) -1;
      q.add(new int[] {mx,my,mdir,0});
      board[mx][my]++;
    }
    for(int i=0; i<repeat; i++){
      copy(false);
      MonsterMove();
      PackManMove(pmx,pmy);
      deadminus();
      copy(true);
    }
  int result = 0;
    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        result += board[i][j];
      }
    }
System.out.println(result);
  }

}
