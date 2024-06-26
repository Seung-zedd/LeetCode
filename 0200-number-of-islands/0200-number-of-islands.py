class Solution(object):
    def numIslands(self, grid):
        m = len(grid)
        n = len(grid[0])
        visited = [[False]*n for x in range(m)] # 1차원 배열을 col만큼 초기화한 후, 그것을 row만큼 반복해서 append
        result = 0 # 현재 방문한 섬의 수

        
        def bfs(start_r, start_c):
            # 사전 세팅
            visited[start_r][start_c] = True
            q = deque()
            q.append((start_r, start_c)) # (0,0)
            
            # 상, 우, 하, 좌 (시계 방향)
            dr = [-1, 0, 1, 0]
            dc = [0, 1, 0, -1]
            while q:
                cur_r, cur_c = q.popleft()
                for k in range(4):
                    # (오답) next_r, next_c이라는 새로운 변수를 할당해줘야함
                    next_r = cur_r + dr[k]
                    next_c = cur_c + dc[k]

                    # 범위
                    # (오답) 3과 4는 고정된 값이지만, 주어진 테스트 케이스는 가변적이므로 m과 n을 사용해야함
                    if 0 <= next_r < m and 0 <= next_c < n:
                        if visited[next_r][next_c] == False and grid[next_r][next_c] == '1':
                            visited[next_r][next_c] = True
                            q.append((next_r, next_c))
            return 1
                
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and visited[i][j] == False:
                    result += bfs(i,j)
        return result