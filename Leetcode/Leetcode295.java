class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int c1=1;
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int c2=0;
            for(int i=0;i<c1;i++){
                TreeNode n=queue.poll();
                level.add(n.val);
                if(n.left!=null){
                    queue.offer(n.left);
                    c2++;
                }
                if(n.right!=null){
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1=c2;
        }
        return result;
    }
}