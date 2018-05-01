package Medium;

import java.util.*;

/**
 * Created by kusha on 2/25/2018.
 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        boolean visited[] = new boolean[numCourses];
        Arrays.fill(visited, false);
        for (int prerequisite[] : prerequisites) {
            if (!map.containsKey(prerequisite[0])) {
                map.put(prerequisite[0], new ArrayList<Integer>());
            }
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int sub = queue.poll();
            boolean currentVisited[] = new boolean[numCourses];
            Queue<Integer> current = new LinkedList();
            if (visited[sub]) {
                continue;
            }
            Arrays.fill(currentVisited, false);
            visited[sub] = true;
            current.offer(sub);
            while (!current.isEmpty()) {
                int temp = current.poll();
                currentVisited[temp] = true;
                visited[temp] = true;
                for (Integer nextValue : map.getOrDefault(temp, new ArrayList<Integer>())) {
                    if (!visited[nextValue]) {
                        current.offer(nextValue);
                    }
                    if (currentVisited[nextValue]) {
                        return false;
                    }
                }


            }
        }
        return true;


    }

    public static void main(String[] args) {
        int pre[][] = new int[2][2];
        pre[0][0] = 0;
        pre[0][1] = 1;
        pre[1][0] = 0;
        pre[1][1] = 2;
        canFinish(3, pre);

    }
}
