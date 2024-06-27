class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        m = len(grid) # row
        n = len(grid[0]) # col
        visited = [[False]*n for _ in range(m)]
        shortest_path = -1

        # 시점 또는 종점이 1이면 -1을 리턴
        if grid[0][0] == 1 or grid[m-1][n-1] == 1:
            return shortest_path

        # bfs 시작
        # 사전 세팅
        # 이때, 0의 값이면 현재의 길이인 1도 추가로 세팅
        visited[0][0] = True
        q = deque()
        q.append((0, 0, 1))
        while q:
            cur_r, cur_c, cur_len = q.popleft() 
            # 8가지 방향 세팅(상, 상우, 우, 우하, 하, 하좌, 좌, 좌상)
            dr = [-1, -1, 0, 1, 1, 1, 0, -1]
            dc = [0, 1, 1, 1, 0, -1, -1, -1]
            # 현재의 좌표가 (m-1,n-1)이면 반복문 종료
            if (cur_r, cur_c) == (m-1, n-1):
                return cur_len
            # transformed from for v in graph[start_v]
            for k in range(8):
                next_r = cur_r + dr[k]
                next_c = cur_c + dc[k]
                # 범위 설정
                # transformed from if v not in visited
                if 0 <= next_r < m and 0 <= next_c < n:
                    if grid[next_r][next_c] == 0 and not visited[next_r][next_c]:
                        visited[next_r][next_c] = True
                        q.append((next_r, next_c, cur_len + 1))
        # 인접 노드를 다 순회했는데 종점에 도달하지 못했으면 -1을 리턴
        return shortest_path
        # (오답)how 종점에서 반복문 종료? -> 애초에 이중 for문을 사용하는 것이 아니였음!
        # 이전의 num of islands 문제는 섬들을 찾아야 하기 때문에 완전탐색을 하는 것이 맞지만, 이번 문제는 시점과 종점이 분명하기 때문에 굳이 완전탐색을 할 필요 x => 아직 이중 for문의 사용 유무가 확실하지 않기 때문에 문제를 많이 풀어봐야함!