class Solution {
    public static int largestRectangleAreaOpt(int[] heights){
         Stack<Integer> stack = new Stack<>();
       int prevSmaller[]= new int[heights.length];
       int nextSmaller[] = new int[heights.length];

       ////finding prev smaller
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                prevSmaller[i] =-1;
            }else{
                int curr = heights[i];
                while (!stack.isEmpty()&&curr<=heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()) prevSmaller[i] = -1;
                else prevSmaller[i] = stack.peek();
                stack.push(i);
            }
        }

        //finding nextSmaller
        stack= new Stack<>();
        for(int i=0;i<=heights.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                int curr;
                if(i==heights.length){
                    curr = -1;
                }else{
                    curr = heights[i];
                }
                while(!stack.isEmpty()&&curr<heights[stack.peek()]){
                    int index = stack.pop();
                    nextSmaller[index] = i;
                }
                stack.push(i);
            }
        }

        ///time to find maxArea
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int height = heights[i];
            int nextSmall = nextSmaller[i];
            int prevSmall = prevSmaller[i];
            int width;
            if(nextSmall==heights.length&&prevSmall==-1){
                width = heights.length;
            }else{
                width = nextSmall-prevSmall-1;
            }

            maxArea = Math.max(maxArea,height*width);
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