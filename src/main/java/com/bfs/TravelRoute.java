package com.bfs;

import java.util.*;

public class TravelRoute {
	public static List<String> solution(String[][] tickets) {
		// 그래프 생성
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		for (String[] ticket : tickets) {
			graph.putIfAbsent(ticket[0], new PriorityQueue<>());
			graph.get(ticket[0]).offer(ticket[1]);
		}

		// 결과 경로를 저장할 리스트
		List<String> path = new LinkedList<>();
		// DFS 탐색 시작
		dfs("ICN", graph, path);
		return path;
	}

	private static void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> path) {
		// 연결된 공항이 남아있으면 DFS를 이어나감

		while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
			String next = graph.get(airport).poll();
			dfs(next, graph, path);
		}
		path.add(0, airport);
		// 더 이상 갈 곳이 없으면 경로에 추가

	}

	public static void main(String[] args) {
		// 예제 입력 테스트
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

		System.out.println(solution(tickets1)); // ["ICN", "JFK", "HND", "IAD"]
		System.out.println(solution(tickets2)); // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
	}
}
