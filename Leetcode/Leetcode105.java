class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int rootValue=preorder[0];
        TreeNode root=new TreeNode(rootValue);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootValue){
                int[] inLeft=Arrays.copyOfRange(inorder,0,i);
                int[] inRight=Arrays.copyOfRange(inorder,i+1,inorder.length);
                int[] preLeft=Arrays.copyOfRange(preorder,1,i+1);
                int[] preRight=Arrays.copyOfRange(preorder,i+1,inorder.length);
                root.left= buildTree(preLeft,inLeft);
                root.right= buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }
}