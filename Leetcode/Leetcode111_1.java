class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int d1=minDepth(root.left);
        int d2=minDepth(root.right);
        if(d2==0){
            return d1+1;
        }
        if(d1==0){
            return d2+1;
        }
        return Integer.min(d1,d2)+1;
    }
}