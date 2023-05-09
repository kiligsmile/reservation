class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode p=root;
        LinkedList<TreeNode> stack =new LinkedList<>();
        long prev=Long.MIN_VALUE;
        while(p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else{
                TreeNode pop=stack.pop();
                if(prev>=pop.val){
                    return false;
                }
                prev=pop.val;
                p=pop.right;
            }
        } 
        return true;
    }
}