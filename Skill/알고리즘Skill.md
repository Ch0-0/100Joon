# 알고리즘 Skill


## 목차
- [경로탐색](#경로-탐색)


## 경로 탐색

1. 왔던길 되돌아가기 <br>
  2차배열에서 경로를 탐색하면서 결과에 도달한 후, 왔던길로 다시 돌아가야하는 Case <br>
  *우,하,좌,상 순위로 간다.
  * 칸을 넘어갈경우 반대쪽으로 나온다.

1-1. 길 탐색하기 (우,하,좌,상) <br>
static int[] dx = new int[]{0,1,0,-1} <br>
static int[] dy = new int[]{01,0,-1,0} <br>
static int[][] backArrX = new int[sizeX][sizeY] <br>
statoc int[][] backArrY = new int[sizeX][sizeY] <br>

1-2. 칸을 넘어갈경우 반대쪽으로 <br>
큐에서 꺼낸 x,y를 담아준다. <br>
x,y = queue.pop <br>
for(int i=0; i<4; i++){  <br>
 px = (x + dx[i] + sizeX) % sizeX  <br>
 py = (y + dy[i] + sizeY) % sizeY <br>
} <br>
backArrX[px][py] = x  <br>
backArrY[px][py] = y  <br>
이럴경우 현재좌표에 AS-IS 좌표가 찍히면서 이전좌표를 알게되니까 되돌아 갈 수 있게된다. <br>

   
