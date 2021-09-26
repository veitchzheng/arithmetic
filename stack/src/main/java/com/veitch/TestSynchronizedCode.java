package com.veitch;

/**
 * @author zhengweichao  2021-04-27 2:07 下午
 **/
public class TestSynchronizedCode {

    static int i = 0;

    public static void main(String[] args) {
        System.out.println(test());

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1, null, treeNode);
        System.out.println(isValidBST(treeNode2));

    }

    private static Integer test() {
        int i = 10;
        try {
            return i;
        }  finally {
            i = 20;
        }
    }


    public static boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left == null && right == null){
            return true;
        } else if(left == null ){
            return isValidBST(right);
        } else if(right == null ){
            return isValidBST(left);
        } else if(left.val < root.val && root.val < right.val){
            return isValidBST(left) && isValidBST(right);
        }
        return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
