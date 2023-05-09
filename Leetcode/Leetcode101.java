class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);

    }
    private boolean check(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(right==null||left==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return check(left.left,right.right)&&check(left.right,right.left);
    }
}