import java.util.*;
import java.io.*;

public class Main{
  public static int[][] board = new int[4][4];
  public static int[][] egg   = new int[4][4];
  public static int[][] dead  = new int[4][4];
  public static int[][] visit = new int[4][4];
  public static int[][] backArr_X = new int[4][4];
  public static int[][] backArr_Y = new int[4][4];

  public static int mCnt, max;
  public static int pmx, pmy;
  public static int back1, back2;
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
  
  public static void PackManEat(int x, int y, int[][] array, int cnt, int eat, int b1, int b2, int b3) {
	//  System.out.println("팩맨 상세위치:"+cnt+"번째 "+x+","+y+"이고 "+eat+"개 먹음 이전방향은 "+b1+" -> "+b2+" -> "+b3);
	  int[][] copyArr = new int[4][4];
	  for(int i=0; i<4; i++) {
		  copyArr[i] = array[i].clone();
	  }
	  if(cnt==3) {
		  if(max<eat) {
	//		  System.out.println("팩맨 갱신됨!! "+x+","+y+"이고 "+eat+"개 먹음 이전방향은 "+b1+" -> "+b2+" -> "+b3);
			  pmx = x;
			  pmy = y;
			  max = eat;
			  back1 = b2;
			  back2 = b3;
		  }
	  } else {
		  
		  for(int i=0; i<4; i++){
		        int rx = x + dx[i];
		        int ry = y + dy[i];
		        if(canGo(rx,ry)) {
		        	eat += copyArr[rx][ry];
		        	copyArr[rx][ry] = 0;
		        	if (cnt == 1) {
			        	PackManEat(rx,ry,copyArr,cnt+1,eat,b1,i,-1);
		        	} else if (cnt == 2) {
			        	PackManEat(rx,ry,copyArr,cnt+1,eat,b1,b2,i);
		        	} else {
		        		PackManEat(rx,ry,copyArr,cnt+1,eat,i,-1,-1);
		        	}
		        }
		  }
	  }
  }

  public static int PackManMove(int x, int y){
    max = -1;
    back1 = -1;
    back2 = -1;
    PackManEat(pmx,pmy,board,0,0,-1,-1,-1);

      int[] tmx = new int[] {1,0,-1,0};
      int[] tmy = new int[] {0,1,0,-1};
      board[pmx][pmy] = 0;
      dead[pmx][pmy] = 2;
      if(back2 != -1){
        int tx = pmx + tmx[back2];
        int ty = pmy + tmy[back2];
        board[tx][ty] = 0;
        dead[tx][ty] = 2;
        board[tx+tmx[back1]][ty+tmy[back1]] = 0;
        dead[tx+tmx[back1]][ty+tmy[back1]] = 2;

        for(int mrepeat=0; mrepeat<mCnt; mrepeat++){
          int[] qp = q.poll();
          int mdx = qp[0];
          int mdy = qp[1];
          int mddir = qp[2];
          int bady = qp[3];
          if(bady == 1) continue;
          if(mdx==tx && mdy ==ty){
          } else if(mdx == pmx && mdy ==pmy){
          } else if(mdx == (tx+tmx[back1]) && mdy == (ty+tmy[back1])){
          } else {
            q.add(new int[] {mdx,mdy,mddir,0});
          }
        }
      /*  System.out.println("==========남은 몬스터=========");
        for(int i=0; i<4; i++) {
      	  for(int j=0; j<4; j++) {
      		if(i==tx && j ==ty){
      			System.out.print("2X ");
            } else if(i == pmx && j ==pmy){
            	System.out.print("3X ");
            } else if(i == (tx+tmx[back1]) && j == (ty+tmy[back1])){
            	System.out.print("1X ");
            } else {
            	System.out.print(board[i][j]+" ");
            }
      		 
      	  }System.out.println();
        }*/
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
      
      int rmdx = 0;
      int rmdy = 0;
      boolean moveYN = false;
      for(int i=0; i<8; i++){
        int rmddir = (mddir + i + 8) % 8;
       // System.out.println(mdx+" "+ddx[rmddir]);
        rmdx = mdx + ddx[rmddir];
        rmdy = mdy + ddy[rmddir];
        if(canGo(rmdx,rmdy)){
          if(dead[rmdx][rmdy] == 0){
              if(!(rmdx == pmx && rmdy == pmy)){
              board[mdx][mdy] --;
              board[rmdx][rmdy] ++;
              q.add(new int[] {rmdx,rmdy,i,0});
              moveYN = true;
              break;
            }
          }
        }
      }
      if(moveYN){
          q.add(new int[] {mdx,mdy,mddir,0});
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
      /*System.out.println("==========알낳은후 상황=========");
      for(int x=0; x<4; x++) {
    	  for(int y=0; y<4; y++) {
    		  System.out.print(egg[x][y]+" ");
    	  }System.out.println();
      }
      System.out.println("==========몬스터 AS-IS=========");
      for(int x=0; x<4; x++) {
    	  for(int y=0; y<4; y++) {
    		  System.out.print(board[x][y]+" ");
    	  }System.out.println();
      }*/
      MonsterMove();
    /*  System.out.println("==========몬스터 TO-BE=========");
      for(int x=0; x<4; x++) {
    	  for(int y=0; y<4; y++) {
    		  System.out.print(board[x][y]+" ");
    	  }System.out.println();
      }
      System.out.println("=======백맨위치: "+pmx+", "+pmy+"===========");*/
      PackManMove(pmx,pmy);
    /*  System.out.println("==========남은 몬스터=========");
      for(int x=0; x<4; x++) {
    	  for(int y=0; y<4; y++) {
    		  System.out.print(board[x][y]+" ");
    	  }System.out.println();
      }*/
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
