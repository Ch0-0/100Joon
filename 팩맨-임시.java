java.util.*;
java.io.*;

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

  public static Queue q<int[]> = new LinkedList<>();
  

  class Monster {
    int x;
    int y;
    public Monster(int x, int y){
      this.x = x;
      this.y = y;
      public boolean isSame(Monster m){
        return this.x = m.x && this.y = m.y;
      }
  }

  public static void(boolean eggborn){
    //알이 부화하면서 몬스터보드에 추가된다.
    if(eggborn){
      for(int i=0; i<4; i++){
        for(int j=0; j<4; j++{
          board[i][j] += egg[i][j];  
        }
      }
     egg = new int[4][4];
    } else { //몬스터가 알을 낳는다.
      for(int i=0; i<4; i++){
        for(int j=0; j<4; j++{
          egg[i][j] += board[i][j];  
        }
      }
    }
  }

  public static boolean canGo(int x, int y){
    return x>0 && y>0 && x<5 && y<5;
  }

  public static int PackManMove(int x, int y){
    int max = -1;
    Queue p<int[]> = new LinkedList<>();
    p.add(new int[] {x,y,0,0});
    
    while(!isEmpty()){
      int[] pp = p.poll();
      int pdx = pp[0];
      int pdy = pp[1];
      int eat = pp[2];
      int cnt = pp[3];
//큐에 각 이동이력 남기기
      if(cnt == 3) {
          if(max<eat){
            max = eat;
            pmx = rx;
            pmy = ry;
          }
        continue;
      }
      

      for(int i=0; i<4; i++){
        int rx = pdx + dx[i];
        int ry = pdy + dy[i];
        if(conGo(rx,ry)){
          eat += board[rx][ry];
          cnt ++;
          p.add(new int[] {rx,ry,eat,cnt});
        } 
      }
      
    }

    
    
    return max;
  }

  public static void MonsterMove(){

    while(!q.isEmpty()){
      int[] qp = q.poll();
      int mdx = qp[0];
      int mdy = qp[1];
      int mddir = qp[2];

      for(int i=0; i<8; i++){
        int rmddir = (mddir + i + 8) % 8;
        int rmdx = mdx + ddx[rmddir];
        int rmdy = mdy + ddy[rmddir];
        if(canGo(rmdx,rmdy)){
          board[mdx][mdy] --;
          board[rmdx][rmdy] ++;
          q.add[
          break;
        }
      }

    }

  }
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    mCnt = Integer.parseInt(st.nextToken());
    int repeat = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    pmx = Integer.parseInt(st.nextToken());
    pmy = Integer.parseInt(st.nextToken());

    for(int i=0; i<mCnt; i++){
      st = new StringTokenizer(br.readLine());
      int mx = Integer.parseInt(st.nextToken());
      int my = Integer.parseInt(st.nextToken());
      int mdir = Integer.parseInt(st.nextToken());
      q.add(new int[] {mx,my,mdir,0});
      board[mx][my]++;
    }

    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++{
          
      }
    }


}
