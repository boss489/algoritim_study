package com.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class stack_queue_30_425836 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>();  // 다리 위에 있는 트럭들을 관리하는 큐
		int time = 0;  // 경과 시간
		int bridgeWeight = 0;  // 현재 다리 위 트럭들의 무게 합
		int idx = 0;  // 현재 대기 트럭의 인덱스

		// 초기 다리 상태를 0으로 채운다 (다리 길이만큼)
		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		}

		while (!bridge.isEmpty()) {
			time++;
			// 다리에서 트럭을 한 대 내림
			bridgeWeight -= bridge.poll();

			// 대기 중인 트럭이 남아있다면 다리에 올릴 수 있는지 확인
			if (idx < truck_weights.length) {
				if (bridgeWeight + truck_weights[idx] <= weight) {
					// 트럭을 다리에 올림
					bridge.add(truck_weights[idx]);
					bridgeWeight += truck_weights[idx];
					idx++;  // 다음 트럭으로 이동
				} else {
					// 트럭이 다리에 못 오르면 0을 추가하여 빈 공간을 표시
					bridge.add(0);
				}
			}
		}

		return time;
	}
}
