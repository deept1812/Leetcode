class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        
        for (int[] inv : invocations) {
            edges.get(inv[0]).add(inv[1]);
            inDegree[inv[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : edges.get(u)) {
                inDegree[v]--;
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    queue.offer(v);
                }
            }
        }
        
        boolean canRemoveAll = true;
        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                canRemoveAll = false;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if (canRemoveAll) {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) result.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) result.add(i);
        }
        return result;
    }
}