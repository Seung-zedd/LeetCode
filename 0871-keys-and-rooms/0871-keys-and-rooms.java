class Solution{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.toArray().length;
        boolean[] visited = new boolean[n];

        // 사전 세팅
        visited[0] = true; // 0번방은 무조건 방문
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(rooms.getFirst());

        while (!q.isEmpty()) {
            List<Integer> keys = q.poll();

            for (Integer key : keys) {
                // key에 해당하는 방을 방문하지 않았으면
                if (!visited[key]) {
                    visited[key] = true;
                    q.offer(rooms.get(key));
                }
            }

        }
        // queue가 비었을 때 모든 visited가 true면 true를 리턴, 그렇지 않으면 false
        int check = 0;
        for (boolean v : visited) {
            if (v) {
                check++;
            }
        }
        return check == visited.length ? true : false;

    }


}