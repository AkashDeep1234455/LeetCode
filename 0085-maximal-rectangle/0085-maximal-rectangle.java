class Solution {
    public static int largestRectangleAreaOpt(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h;
            if (i == heights.length) {
                h = 0;
            } else {
                h = heights[i];
            }
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;

    }
    public int maximalRectangle(char[][] matrix) {
          int height[] =new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            height[i] = matrix[0][i]-'0';
        }
        int maxArea=largestRectangleAreaOpt(height);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') {
                    height[j] += matrix[i][j] - '0';
                }else{
                    height[j] = 0;
                }
            }
            int area =largestRectangleAreaOpt(height);
            if(area>maxArea) maxArea=area;
        }
        return maxArea;
    }
}