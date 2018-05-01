import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by kusha on 3/19/2018.
 */
public class CherryPickGit {
    Map<String, List<String>> parentMap;

    CherryPickGit(List<List<String>> parents) {
        parentMap = new HashMap<>();
        for (List<String> children : parents) {
            parentMap.put(children.get(0), new ArrayList<>());
            for (int i = 1; i < children.size(); i++) {
                parentMap.get(children.get(0)).add(children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        List<List<String>> input = new ArrayList();
        while (true) {
            try {
                input.add(Arrays.asList(scanner.readLine().split(" ")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (input.get(input.size() - 1).size() == 1)
                break;
        }
        CherryPickGit git = new CherryPickGit(input);
        while (true) {
            String str = null;
            try {
                str = scanner.readLine();
                if (str.split(" ").length < 3)
                    break;

                try {
                    List<String> cherrypickSteps = null;
                    cherrypickSteps = git.rebase(str.split(" ")[2], str.split(" ")[3]);
                    for (String cherrypickStep : cherrypickSteps) {
                        System.out.println(cherrypickStep);
                    }

                } catch (Exception e) {
                    System.out.println("No such element found");
                }
            } catch (IOException e) {
                e.printStackTrace();

            }

        }

    }

    // bfs for finding all the parents and keeping track of how far they are from the TO element we essentially update distanceMap
    private void bfs(HashMap<String, Integer> distanceMap, String current, int count) {
        if (distanceMap.get(current) == count)
            return;

        distanceMap.put(current, Math.min(count, distanceMap.getOrDefault(current, Integer.MAX_VALUE)));
        for (String parent : parentMap.get(current)) {
            bfs(distanceMap, parent, count + 1);
        }
    }

    // bfs for finding the shortest path from the FROM element we are utilizing distanceMap
    private void bfs(HashMap<String, Integer> distanceMap, String current, List<String> currentList, List<String> output) {
        if (distanceMap.containsKey(current)) {
            if (output.size() == 0 || distanceMap.get(output.get(output.size() - 1)) > distanceMap.get(current)) {
                output.clear();
                output.addAll(currentList);
            }
            return;
        }
        for (String parent : parentMap.get(current)) {
            currentList.add(parent);
            bfs(distanceMap, parent, currentList, output);
            currentList.remove(currentList.size() - 1);
        }
    }

    public List<String> rebase(String commitId1, String commitId2) throws Exception {
        if (!parentMap.containsKey(commitId1) || !parentMap.containsKey(commitId2)) {
            throw new Exception("no such element");
        }
        List<String> rawOutput = new ArrayList<>(); //un-formatted text
        List<String> output = new ArrayList<>(); // formatted text;
        HashMap<String, Integer> distanceMap = new HashMap<>();
        bfs(distanceMap, commitId2, 0);
        bfs(distanceMap, commitId1, new ArrayList<String>(), rawOutput);
        rawOutput.remove(rawOutput.size() - 1);
        Collections.reverse(rawOutput);
        if (rawOutput.isEmpty() && !distanceMap.containsKey(commitId1)) {
            throw new Exception("no path found");
        }
        output.add("git checkout " + commitId2);
        for (String raw : rawOutput) {
            output.add("git cherry-pick " + raw);
        }
        output.add("git cherry-pick " + commitId1);
        return output;
    }
}


/*
base case could not handle
  <-6 <-3<-2<-1
7    \
  <-5<-4<-8
     \  /
      9

 here for rebase 1 8 will now give 3 and 2
 and rebase 8 1 will now give 4

 Iniial approach was just plain DFS based and we were trying to
 find the common element, the approach we are actually finding the closest checkin

 */