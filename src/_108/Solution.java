package _108;

import node.TreeNode;

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
		return ToBST(nums,0,nums.length-1);
	}

	public static TreeNode ToBST(int nums[],int left,int right){
		if(left>right) {
            return null;
        }
		int mid = (left+right) /2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = ToBST(nums,left,mid-1);
		root.right = ToBST(nums,mid+1,right);
		return root;
	}

	public static void main(String[] args) {
    	new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
	}
}