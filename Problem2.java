//https://leetcode.com/problems/rotting-oranges/
//Time complexity : O(N)
//Spaces complexity : O(N)
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int dirs[][] = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int coord[] = q.poll();
                for (int dir[] : dirs) {
                    int x = coord[0] + dir[0];
                    int y = coord[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.add(new int[] { x, y });
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? (time - 1) : -1;

    }
}