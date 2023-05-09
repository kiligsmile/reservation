class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        // if(root.left==null&&root.right==null){
        //     return 1;
        // }
        int d1=maxDepth(root.left);
        int d2=maxDepth(root.right);
        return Integer.max(d1,d2)+1;
    }
}