class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode curr=root;
        List<Integer> result = new ArrayList<>();
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode pop=stack.pop();
                result.add(pop.val);
                curr=pop.right;
            }
        }
        return result;
    }
}