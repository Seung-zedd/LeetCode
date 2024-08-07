class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        r = len(grid)
        c = len(grid[0])
        shortest_path = -1
        visited = [[False]*c for x in range(r)] # 1차원 배열을 col만큼 복사한 후, row만큼 iterate

        # hidden condition_1: 시점이나 종점이 막혀있으면 bfs 호출 불가
        if grid[0][0] == 1 or grid[r-1][c-1] == 1:
            return shortest_path

        # 편의상, a_ij로 표현
        def bfs(start_i, start_j):
            # 사전 세팅
            q = deque()
            q.append(((start_i, start_j, 1)))
            visited[start_i][start_j] = True

            while q:
                cur_i, cur_j, cur_len = q.popleft()

                # 현재 좌표가 종점이면 while문을 종료
                if (cur_i, cur_j) == (r-1, c-1):
                    return cur_len

                # 좌상부터 시계방향으로 시작
                dr = [-1, -1, -1, 0, 1, 1, 1, 0]
                dc = [-1, 0, 1, 1, 1, 0, -1, -1]

                for x in range(8):
                    next_i = cur_i + dr[x]
                    next_j = cur_j + dc[x]

                    # 경계값 범위
                    if 0 <= next_i < r and 0 <= next_j < c:
                        if grid[next_i][next_j] == 0 and not visited[next_i][next_j]:
                            visited[next_i][next_j] = True
                            q.append((next_i, next_j, cur_len + 1)) # 방문을 했으니까 길이 1 추가

            # bfs를 다 순회했는데 종점에 도달하지 못했으면 -1을 리턴
            return shortest_path
            
        # 드모르간 법칙에 의해 바로 bfs 호출
        shortest_path = bfs(0,0) # cur_len으로 업데이트
        return shortest_path