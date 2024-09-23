package com.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MissileInterception {
	//https://school.programmers.co.kr/learn/courses/30/lessons/181188
	public static int solution(int[][] targets) {
		// 구간 정렬: 종료점 기준으로 정렬
		Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
		int result = 0;
		double lastIntercept = -1;  // 마지막으로 요격한 미사일 위치
		for (int[] target : targets) {
			int start = target[0];
			int end = target[1];

			// 새로운 요격 미사일이 필요한 경우
			if (lastIntercept < start) {
				result++;  // 새로운 미사일 발사
				lastIntercept = end - 0.5;  // 끝점을 포함하지 않도록 약간 왼쪽으로 발사 위치 설정
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] targets = {
			{10, 14},
			{11, 13},
			{5, 12},
			{4, 8},
			{4, 5},
			{3, 7},
			{1, 4}
		};
		System.out.println(solution(targets));  // 예상 결과: 3
	}
}
