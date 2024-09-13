package com.bfs;

import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/1844


public class bfs_30_1844 {
	class Position {
		int x;
		int y;
	}
	public static final int visted = 1;
	int[][] maps;

	public int solution(int[][] maps) {
		this.maps = maps;
		int answer = 0;
		Position currentPosition = new Position();
		currentPosition.x = 0;
		currentPosition.y = 0;
		Stack s = new Stack();
		s.push(currentPosition);

		while(true) {
			maps[currentPosition.x][currentPosition.y] = visted;

			if (currentPosition.x == maps.length - 1 && currentPosition.y == maps[0].length - 1)
				return answer;

			for(int i = 0; i < 3; i++){
				if(movable(currentPosition, i)){
					s.push(currentPosition);
					move_to(currentPosition, i);
					break;
				}
			}
		}
	}

	//check can move to current position
	public boolean movable(Position currentPosition, int i) {
		Position nextPosition = move_to(currentPosition, i);
		if(nextPosition.x >= 0 && nextPosition.x < maps.length && nextPosition.y >= 0 && nextPosition.y < maps[0].length && maps[nextPosition.x][nextPosition.y] == 0)
			return true;
		return false;
	}

	//add maze can move to 4 directions
	public Position move_to(Position currentPosition, int i){
		Position nextPosition = new Position();
		nextPosition.x = currentPosition.x;
		nextPosition.y = currentPosition.y;
		switch(i){
			case 0:
				nextPosition.x -= 1;
				break;
			case 1:
				nextPosition.x += 1;
				break;
			case 2:
				nextPosition.y -= 1;
				break;
			case 3:
				nextPosition.y += 1;
				break;
		}
		return nextPosition;
	}


}
