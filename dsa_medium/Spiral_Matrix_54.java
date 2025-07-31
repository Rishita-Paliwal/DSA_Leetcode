class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n =matrix[0].length;
        //left to right
        //top to bottom
        //right to lef
        //move up
        //maintain index
        int top=0;
        int bottom = m-1;
        int left=0;
        int right= n-1;

    while(top<=bottom && left<=right){
        //left to right
        for(int j=left;j<=right;j++){
            result.add(matrix[top][j]);
        }
        //shrink the row
        top++;
        //top to bottom
        for(int j=top;j<=bottom;j++){
            result.add(matrix[j][right]);
        }
        //shrink right column
        right--;
        //right to left
        if(top<=bottom){
            for(int j=right;j>=left;j--){
                result.add(matrix[bottom][j]);
            }
            //shrink bottom
            bottom--;
        }
        //move up
        if(left<=right){
            for(int j=bottom;j>=top;j--){
                result.add(matrix[j][left]);
            }
            left++;
        }

    }
    return result;
        
    }
}