class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 사전 세팅
        int[] dist = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (curCost > dist[curNode]) continue;

            for (int i = 0; i < times.length; i++) {
                // 시작 노드가 k일 때만 인접 노드 탐색
                if (times[i][0] == curNode) {
                    int nextNode = times[i][1];
                    int cost = times[i][2];
                    // 일단 비용 업데이트
                    int nextCost = curCost + cost;

                    if (nextCost < dist[nextNode]) {
                        dist[nextNode] = nextCost;
                        pq.offer(new int[]{nextNode, nextCost});
                    }
                }

            }
        }
        // dist에서 최댓값을 구한다
        int max_val = 0;
        for (int i = 1; i < dist.length; i++) {
            max_val = Math.max(max_val, dist[i]);
        }

        return max_val == Integer.MAX_VALUE ? -1 : max_val;

    }
}