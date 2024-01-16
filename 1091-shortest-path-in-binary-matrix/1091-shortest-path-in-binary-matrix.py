class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        # 최단거리는 무지성으로 bfs로 풀자.
        r = len(grid)  # row
        c = len(grid[0])  # col
        visited = [[False] * c for _ in range(r)]
        shortest_length = -1

        # set 8-direction
        dr = [-1, 1, 0, 0, -1, -1, 1, 1]
        dc = [0, 0, -1, 1, -1, 1, -1, 1]

        # return -1 if there is no clear path
        if grid[0][0] != 0 or grid[r - 1][c - 1] != 0:
            return shortest_length

        # bfs
        visited[0][0] = True
        q = deque()
        q.append((0, 0, 1))  # indicate the length
        while q:
            cur_r, cur_c, cur_len = q.popleft()

            # if current coordinate reaches the end point, return length
            if (cur_r, cur_c) == (r - 1, c - 1):
                shortest_length = cur_len
                return shortest_length

            for i in range(8):
                next_r = cur_r + dr[i]
                next_c = cur_c + dc[i]
                if 0 <= next_r < r and 0 <= next_c < c:
                    if grid[next_r][next_c] == 0 and not visited[next_r][next_c]:
                        q.append((next_r, next_c, cur_len + 1))
                        visited[next_r][next_c] = True
        # bfs를 호출했지만, 종점에 도착하지 못했기 때문에 -1을 리턴
        return shortest_length