import java.util.*;

public class LC863_AllNodesDistanceKInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(K == 0) return Collections.singletonList(target.val);

        Stack<TreeNode> parents = new Stack<>();
        findTarget(root, target, parents);

        List<Integer> res = new ArrayList<>();
        distanceKSubtree(target, K, res);

        TreeNode child = target;
        while(!parents.isEmpty()) {
            TreeNode cur = parents.pop();
            if(K == 1) {
                res.add(cur.val);
                break;
            }

            if(child == cur.left) distanceKSubtree(cur.right, K - 2, res);
            else distanceKSubtree(cur.left, K - 2, res);

            child = cur;
            K--;
        }

        return res;
    }

    private boolean findTarget(TreeNode root, TreeNode target, Stack<TreeNode> parents) {
        if(root == null) return false;
        if(root == target) return true;

        parents.push(root);

        if(findTarget(root.left, target, parents)) return true;
        if(findTarget(root.right, target, parents)) return true;

        parents.pop();
        return false;
    }

    private void distanceKSubtree(TreeNode root, int K, List<Integer> res) {
        if(root == null) return ;
        if(K == 0) {
            res.add(root.val);
            return;
        }

        distanceKSubtree(root.left, K - 1, res);
        distanceKSubtree(root.right, K - 1, res);
    }

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new ArrayList<>();
//
//        if(K == 0){
//            res.add(target.val);
//            return res;
//        }
//
//        getDist(root, target, K, res);
//        return res;
//    }
//
//    private int getDist(TreeNode root, TreeNode target, int K, List<Integer> res){
//        if(root == null) return -1;
//
//        if(target == root){
//            addNodes(root, K, res);
//            return 0;
//        }
//
//        int L = getDist(root.left, target, K, res);
//        int R = getDist(root.right, target, K, res);
//
//        int dist = -1;
//
//        if(L != -1){
//            dist = L + 1;
//            if(dist == K){
//                res.add(root.val);
//            } else if(dist < K){
//                addNodes(root.right, K - dist - 1, res);
//            }
//        }
//
//        if(R != -1){
//            dist = R + 1;
//            if(dist == K){
//                res.add(root.val);
//            } else if(dist < K){
//                addNodes(root.left, K - dist - 1, res);
//            }
//        }
//
//        return dist;
//    }
//
//    private void addNodes(TreeNode root, int K, List<Integer> res){
//        if(root == null) return ;
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        int level = 0;
//
//        while(!q.isEmpty()){
//            if(level == K) break;
//
//            int cnt = q.size();
//            for(int i = 0; i < cnt; i++){
//                TreeNode cur = q.poll();
//                if(cur.left != null) q.offer(cur.left);
//                if(cur.right != null) q.offer(cur.right);
//            }
//
//            level++;
//        }
//
//        for(TreeNode node: q){
//            res.add(node.val);
//        }
//    }

    // convert tree to an undirected graph
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        buildGraph(root, graph);
//
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(target.val);
//        HashSet<Integer> visited = new HashSet<>();
//        visited.add(target.val);
//        int level = 0;
//
//        while(!q.isEmpty()){
//            if(level == K) break;
//
//            int cnt = q.size();
//            for(int i = 0; i < cnt; i++){
//                int cur = q.poll();
//                if(graph.get(cur) != null){
//                    for(int neighbor: graph.get(cur)){
//                        if(!visited.contains(neighbor)){
//                            visited.add(neighbor);
//                            q.offer(neighbor);
//                        }
//                    }
//                }
//            }
//
//            level++;
//        }
//
//        return new ArrayList<>(q);
//    }
//
//    private void buildGraph(TreeNode root, HashMap<Integer, List<Integer>> graph){
//        if(root == null) return;
//
//        graph.putIfAbsent(root.val, new ArrayList<>());
//        if(root.left != null){
//            graph.get(root.val).add(root.left.val);
//            graph.putIfAbsent(root.left.val, new ArrayList<>());
//            graph.get(root.left.val).add(root.val);
//        }
//
//        if(root.right != null){
//            graph.get(root.val).add(root.right.val);
//            graph.putIfAbsent(root.right.val, new ArrayList<>());
//            graph.get(root.right.val).add(root.val);
//        }
//
//        buildGraph(root.left, graph);
//        buildGraph(root.right, graph);
//    }
}
