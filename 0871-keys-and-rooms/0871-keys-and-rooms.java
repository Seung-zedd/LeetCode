class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        // bfs 탐색
        // queue: keys(Edge)들을 추가하기 위한 자료구조
        Queue<List<Integer>> q = new LinkedList<>();
        visited[0] = true; // 0번방은 무조건 방문
        q.offer(rooms.getFirst());

        while (!q.isEmpty()) {
            List<Integer> keys = q.poll();

            for (Integer key : keys) {
                if (!visited[key]) {
                    visited[key] = true;
                    q.offer(rooms.get(key)); // key에 해당하는 room에 들어가서 distinct keys를 얻음

                }
            }
        }

        // 하나라도 방문을 안 했으면 false를 리턴
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;

    }
    }
}