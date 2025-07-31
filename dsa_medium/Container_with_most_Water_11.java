class Solution {
    public int maxArea(int[] height){
        int max =0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int w = right-left;
            int area = w*h;
            max = Math.max(area,max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
    /*public int BruteForcemaxArea(int[] height) {
        int max =0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int h = Math.min(height[i],height[j]); //min height
                int w = j-i;                  //width
                int area = h*w;
                max = Math.max(area,max);//area
                //max area

            }
        }
        return max;

        
    }*/
}