class Solution(object):
    def canVisitAllRooms(self, rooms):
        def dfs(room_number):
            visited.add(room_number)

            for key in rooms[room_number]:
                if key not in visited:
                    dfs(key)
                    
        visited = set()
        dfs(0)
        return len(visited) == len(rooms)