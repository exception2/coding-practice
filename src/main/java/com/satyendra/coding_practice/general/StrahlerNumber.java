package general;

import java.util.*;


public class StrahlerNumber {

    public static int getStrahlerNumber(int[][] relationships) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();

        // Create the parent-child map from the 2D array
        for (int[] relation : relationships) {
            int parent = relation[0];
            int child = relation[1];

            parentChildMap.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            childNodes.add(child);
        }

        // Find root nodes (those not appearing as children)
        Set<Integer> allNodes = new HashSet<>(parentChildMap.keySet());
        Set<Integer> rootNodes = new HashSet<>(allNodes);
        rootNodes.removeAll(childNodes);

        // Cache to store Strahler numbers for quick lookup
        Map<Integer, Integer> strahlerCache = new HashMap<>();

        int maxStrahler = 1;
        // Calculate Strahler number for all root nodes
        for (Integer root : rootNodes) {
            int rootStrahler = calculateStrahlerRecursively(root, parentChildMap, strahlerCache);
            maxStrahler = Math.max(maxStrahler, rootStrahler);
        }

        return maxStrahler;
    }

    // Recursive function to calculate the Strahler number
    private static int calculateStrahlerRecursively(int node, Map<Integer, List<Integer>> parentChildMap,
                                                    Map<Integer, Integer> strahlerCache) {
        if (strahlerCache.containsKey(node)) {
            return strahlerCache.get(node);
        }

        if (!parentChildMap.containsKey(node)) {
            // If node has no children, Strahler number is 1
            strahlerCache.put(node, 1);
            return 1;
        }

        List<Integer> childStrahlers = new ArrayList<>();
        for (Integer child : parentChildMap.get(node)) {
            childStrahlers.add(calculateStrahlerRecursively(child, parentChildMap, strahlerCache));
        }

        // The Strahler number is the maximum of the children's Strahler numbers
        int maxStrahler = Collections.max(childStrahlers);

        // If the node has 2 or more children, the Strahler number is max of children + 1
        if (childStrahlers.size() >= 2) {
            maxStrahler += 1;
        }

        strahlerCache.put(node, maxStrahler);
        return maxStrahler;
    }

    public static void main(String[] args) {
        int[][] relationships = {
                {20, 30},
                {10, 20},
                {20, 40},
                {40, 50},
                {40, 60}
        };

        int maxStrahler = getStrahlerNumber(relationships);
        System.out.println("Maximum Strahler Number: " + maxStrahler); // Expected output: 2
    }
}

