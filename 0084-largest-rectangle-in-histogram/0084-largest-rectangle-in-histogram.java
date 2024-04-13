class Solution {
    public int largestRectangleArea(int[] heights) {
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
}