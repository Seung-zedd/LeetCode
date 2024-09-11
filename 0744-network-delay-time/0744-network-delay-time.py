class Solution(object):
    def networkDelayTime(self, times, n, k):
        costs = {}
        pq = []
        heapq.heappush(pq, (0, k))

        while pq:
            cur_cost, cur_v = heapq.heappop(pq)

            if cur_v not in costs:
                costs[cur_v] = cur_cost
                if len(costs) == n:
                    return cur_cost
                for v, next_v, cost in times:
                    if v == cur_v:
                        next_cost = cur_cost + cost
                        heapq.heappush(pq, (next_cost, next_v))
        return -1