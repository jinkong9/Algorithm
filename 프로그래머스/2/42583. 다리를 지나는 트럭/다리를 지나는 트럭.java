import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int bridgeWeight = 0;
        int time = 0;
        int index = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            time++;
            bridgeWeight -= bridge.poll();

            int truck = truck_weights[index];
            if (bridgeWeight + truck <= weight) {
                bridge.offer(truck);
                bridgeWeight += truck;
                index++;
            } else {
                bridge.offer(0);
            }
        }

        return time + bridge_length;
    }
}
