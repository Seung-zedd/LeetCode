class Solution(object):
    def networkDelayTime(self, times, n, k):
        costs = {}
        pq = []
        heapq.heappush(pq, (0, k))  # 시작 노드 추가

        while pq:
            cur_cost, cur_v = heapq.heappop(pq)
            if cur_v not in costs:
                costs[cur_v] = cur_cost
                if len(costs) == n: # 모든 노드를 방문했으면 최소 비용을 리턴
                    return cur_cost
                # 인접 노드 탐색(먼저 방문을 해야 탐색 시작)
                for path in times:  # path is row
                    if cur_v == path[0]:  # 시작 노드인지 확인
                        cost = path[2]
                        next_v = path[1]
                        next_cost = cur_cost + cost
                        heapq.heappush(pq, (next_cost, next_v))
        return -1