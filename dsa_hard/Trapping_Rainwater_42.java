class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int water =0;
        int leftMax=0;
        int rightMax =0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax= height[left];
                }else{
                    water= water+leftMax-height[left];
                }left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax= height[right];
                }else{
                    water = water +rightMax-height[right];
                }
                right--;
            }
        }
        return water;
        
    }
}