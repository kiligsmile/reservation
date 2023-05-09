class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int c1=1;
        boolean odd=true;
        while(!queue.isEmpty()){
            LinkedList<Integer> level =new LinkedList<>();
            int c2=0;
            for(int i=0;i<c1;i++){
                TreeNode n=queue.poll();
                if(odd){
                    level.offerLast(n.val);
                }
                else{
                    level.offerFirst(n.val);
                }

                if(n.left!=null){
                    queue.offer(n.left);
                    c2++;
                }
                if(n.right!=null){
                    queue.offer(n.right);
                    c2++;
                }
            }
            odd=!odd;
            result.add(level);
            c1=c2;
        }
        return result;
    }
}