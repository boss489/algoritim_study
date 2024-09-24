package com.bfs;

import java.util.*;

public class WordTransformation {
	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/43163#
		System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); // 출력: 4
		System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));        // 출력: 0
	}

	public static int solution(String begin, String target, String[] words) {
		// words 배열을 List로 변환
		List<String> wordList = Arrays.asList(words);

		// target이 words에 없으면 변환할 수 없음
		if (!wordList.contains(target)) {
			return 0;
		}

		// BFS를 위한 큐 초기화
		Queue<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(begin, 0));  // 시작 단어와 변환 횟수를 저장
		Set<String> visited = new HashSet<>();
		visited.add(begin);  // 시작 단어를 방문 처리

		while (!queue.isEmpty()) {
			WordNode current = queue.poll();
			String currentWord = current.word;
			int steps = current.steps;

			// 현재 단어가 target과 같으면 변환 횟수를 반환
			if (currentWord.equals(target)) {
				return steps;
			}

			// 변환 가능한 단어 탐색
			for (String word : wordList) {
				if (!visited.contains(word) && canTransform(currentWord, word)) {
					visited.add(word);
					queue.add(new WordNode(word, steps + 1));
				}
			}
		}

		// target에 도달할 수 없는 경우
		return 0;
	}

	// 두 단어가 한 글자만 다를 때 변환 가능 여부를 확인하는 메서드
	private static boolean canTransform(String word1, String word2) {
		int diffCount = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				diffCount++;
			}
			if (diffCount > 1) {
				return false;
			}
		}
		return diffCount == 1;
	}

	// 단어와 변환 횟수를 저장하는 클래스
	static class WordNode {
		String word;
		int steps;

		WordNode(String word, int steps) {
			this.word = word;
			this.steps = steps;
		}
	}
}
