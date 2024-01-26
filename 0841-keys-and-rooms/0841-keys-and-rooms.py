class Solution(object):
    def canVisitAllRooms(self, rooms):
        visited_room = set()

        def dfs(room_number):
            visited_room.add(room_number)

            # 시간복잡도: 3000
            for room in rooms[room_number]:
                if room not in visited_room:
                    dfs(room)
        dfs(0)

        return len(rooms) == len(visited_room)