class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
	    return root = doPut(root,val);
    }
    private TreeNode doPut(TreeNode node,int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = doPut(node.left,val);
        } 
        else if (node.val < val) {
            node.right = doPut(node.right,val);
        } 
        return node;
    }
}