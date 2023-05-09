class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode curr=root;
        List<Integer> result = new ArrayList<>();
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                result.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode pop=stack.pop();
                curr=pop.right;
            }
        }
        return result;
    }
}