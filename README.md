# Programmers.Level3_Java_SchoolRoad
Programmers DP Level3_SchoolRoad

input으로 map의 사이즈 가로m과 세로n, 물웅덩이의 위치 int[][] puddles를 받는다.
(1,1)을 집(출발점) (m,n)이 학교(도착점)이라 하고 집으로 부터 학교의 최단거리의 갯수를 구하는 문제이다.

```java
for (int i = 1; i <= n; i++)
  for (int j = 1; j <= m; j++)
    map[i][j] = ...
```

형태로도 행마다 검사하는 방식으로도 해보고

```java
for (int i = 1; i <= m+n; i++)
  for (int j = 1; j < n; j++)
    map[j][i-j] = ...
    ...
```

형태로 대각선으로 검사하도록 해보았는데 틀려서 보니 puddles의 점을 행과열의 순서를 반대로 대입해 컴파일 에러가 계속 났었다. 문제를 더 잘 읽어야 겠다...
그리고 예외 case를 찾았는데 

![screenshot](예외.PNG)
   
   로 map이 형성되어 돌아가야될 경우 최단거리 검사를 오른쪽과 아래쪽으로 검사해 나가기 때문에 돌아가는 경우를 계산해내지 못하는 코드였다. 하지만 통과되었기 때문에 이 부분에서 문제 수정이 이루어 져야 할 것 같다.
