class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        TreeNode curr=root;
        TreeNode pop=null;
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode peek=stack.peek();
                if(peek.right==null||peek.right==pop){
                    pop=stack.pop();
                    result.add(pop.val);
                }
                else{
                    curr=peek.right;
                }
            }
        }
        return result;
    }
}