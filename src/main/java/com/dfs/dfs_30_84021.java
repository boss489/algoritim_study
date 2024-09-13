package com.dfs;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/84021

public class dfs_30_84021 {
	// 게임 보드에서 빈 공간이나 퍼즐 조각을 추출하는 함수
	public List<List<int[]>> extractPieces(int[][] board, int value) {
		int n = board.length;
		boolean[][] visited = new boolean[n][n];
		List<List<int[]>> pieces = new ArrayList<>();

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == value && !visited[i][j]) {
					List<int[]> piece = new ArrayList<>();
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[]{i, j});
					visited[i][j] = true;

					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						int x = cur[0], y = cur[1];
						piece.add(new int[]{x, y});

						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d], ny = y + dy[d];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == value && !visited[nx][ny]) {
								visited[nx][ny] = true;
								queue.offer(new int[]{nx, ny});
							}
						}
					}

					// (0, 0) 기준으로 위치 조정
					pieces.add(normalizePiece(piece));
				}
			}
		}

		return pieces;
	}

	// 좌표를 (0, 0) 기준으로 정렬하는 함수
	public List<int[]> normalizePiece(List<int[]> piece) {
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		for (int[] p : piece) {
			minX = Math.min(minX, p[0]);
			minY = Math.min(minY, p[1]);
		}
		List<int[]> normalized = new ArrayList<>();
		for (int[] p : piece) {
			normalized.add(new int[]{p[0] - minX, p[1] - minY});
		}
		return normalized;
	}

	// 90도 회전하는 함수
	public List<int[]> rotate(List<int[]> piece, int n) {
		List<int[]> rotatedPiece = new ArrayList<>();
		for (int[] p : piece) {
			rotatedPiece.add(new int[]{p[1], n - 1 - p[0]});
		}
		return normalizePiece(rotatedPiece);  // 회전 후 다시 정렬
	}

	// 퍼즐 조각이 빈 공간에 맞는지 확인하는 함수
	public boolean canFit(List<int[]> emptySpace, List<int[]> piece) {
		if (emptySpace.size() != piece.size()) {
			return false;
		}

		// 좌표를 정렬하여 비교
		emptySpace.sort(Comparator.comparingInt(a -> a[0] * 50 + a[1]));
		piece.sort(Comparator.comparingInt(a -> a[0] * 50 + a[1]));

		for (int i = 0; i < emptySpace.size(); i++) {
			if (emptySpace.get(i)[0] != piece.get(i)[0] || emptySpace.get(i)[1] != piece.get(i)[1]) {
				return false;
			}
		}
		return true;
	}

	// solution 함수
	public int solution(int[][] game_board, int[][] table) {
		int n = game_board.length;

		// 빈 공간 추출 (game_board에서 0인 부분)
		List<List<int[]>> emptySpaces = extractPieces(game_board, 0);

		// 퍼즐 조각 추출 (table에서 1인 부분)
		List<List<int[]>> puzzlePieces = extractPieces(table, 1);

		// 퍼즐 조각 회전 (각각의 회전 상태 저장)
		boolean[] usedPieces = new boolean[puzzlePieces.size()];
		int filledCount = 0;

		for (List<int[]> emptySpace : emptySpaces) {
			boolean foundFit = false;

			for (int i = 0; i < puzzlePieces.size(); i++) {
				if (usedPieces[i]) {
					continue;
				}

				List<int[]> piece = puzzlePieces.get(i);
				for (int r = 0; r < 4; r++) {  // 4번 회전
					if (r > 0) {
						piece = rotate(piece, n);
					}

					if (canFit(emptySpace, piece)) {
						filledCount += emptySpace.size();
						usedPieces[i] = true;
						foundFit = true;
						break;
					}
				}

				if (foundFit) {
					break;
				}
			}
		}

		return filledCount;
	}

	public static void main(String[] args) {
		dfs_30_84021 sol = new dfs_30_84021();
		int[][] game_board1 = {
			{1, 1, 0, 0, 1, 0},
			{0, 0, 1, 0, 1, 0},
			{0, 1, 1, 0, 0, 1},
			{1, 1, 0, 1, 1, 1},
			{1, 0, 0, 0, 1, 0},
			{0, 1, 1, 1, 0, 0}
		};

		int[][] table1 = {
			{1, 0, 0, 1, 1, 0},
			{1, 0, 1, 0, 1, 0},
			{0, 1, 1, 0, 1, 1},
			{0, 0, 1, 0, 0, 0},
			{1, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0}
		};

		System.out.println(sol.solution(game_board1, table1));  // 14
	}


}
