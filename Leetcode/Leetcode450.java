class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=deleteNode(root.left,key);
            return root;
        }
        if(root.val<key){
            root.right=deleteNode(root.right,key);
            return root;
        }
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }
        TreeNode s=root.right;
        while(s.left!=null){
            s=s.left;
        }
        s.right=deleteNode(root.right,s.val);
        s.left=root.left;
        return s;
    }
}