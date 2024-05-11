class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        r = len(grid) # row
        c = len(grid[0]) # col
        visited = [[False]*c for i in range(r)]
        shortest_path = -1

        # (0,0)이 1이거나 (r-1,c-1)이 1이면 막혀서 갈 수 없음
        if grid[0][0] == 1 or grid[r-1][c-1] == 1:
            return shortest_path
        
        def bfs(start_x, start_y):
            # 사전 세팅
            visited[start_x][start_y] = True
            q = deque()
            q.append((start_x, start_y, 1))

            # row, col의 인덱스에 맞춤(아래, 오른쪽으로 갈수록 증가)
            # 11시 방향부터 시작
            dr = [-1, -1, -1, 0, 1, 1, 1, 0]
            dc = [-1, 0, 1, 1, 1, 0, -1, -1]

            while q:
                # len 추가 이유: bfs(인접 노드 탐색)할 때 최단거리(대각선으로 가는 경우) 발견하기 위함
                cur_x, cur_y, cur_len = q.popleft() # (0,0,1)
                shortest_path = cur_len

                # 종료 조건: 
                if (cur_x, cur_y) == (r-1, c-1): 
                    return shortest_path

                for i in range(8):
                    next_x = cur_x + dr[i]
                    next_y = cur_y + dc[i]
                
                # set a boundary
                    if 0 <= next_x <= r-1 and 0 <= next_y <= c-1:
                        # grid의 값이 0이면 방문
                        if grid[next_x][next_y] == 0 and visited[next_x][next_y] == False:
                            q.append((next_x, next_y, cur_len + 1))
                            visited[next_x][next_y] = True
            # 인접 노드를 다 탐색했는데 도착점에 도달하지 못했으면 -1을 리턴
            return -1

        # grid 순회
        for i in range(r):
            for j in range(c):
                if visited[i][j] == False and grid[i][j] == 0:
                    return bfs(i,j)
        