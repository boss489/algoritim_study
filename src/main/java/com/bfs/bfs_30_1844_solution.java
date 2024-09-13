package com.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_30_1844_solution {
	// 상, 하, 좌, 우 방향
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};

	public int solution(int[][] maps) {
		int n = maps.length;      // 맵의 행 크기
		int m = maps[0].length;   // 맵의 열 크기

		// BFS를 위한 큐 (x, y 좌표와 이동 칸 수를 저장)
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1});  // 시작 좌표 (0, 0)에서 시작, 1칸부터 시작

		// 방문 여부를 저장할 배열
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		// BFS 시작
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int distance = current[2];

			// 상대 팀 진영 도착 시 거리 반환
			if (x == n - 1 && y == m - 1) {
				return distance;
			}

			// 상, 하, 좌, 우로 이동
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 맵 범위 내에서 이동 가능하고, 방문하지 않았으며, 벽이 아닌 경우에만 이동
				if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny, distance + 1});
					visited[nx][ny] = true;  // 방문 처리
				}
			}
		}

		// 상대 팀 진영에 도착하지 못하면 -1 반환
		return -1;
	}
}
