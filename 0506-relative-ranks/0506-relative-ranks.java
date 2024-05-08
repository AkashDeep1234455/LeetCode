class Solution {
    public String[] findRelativeRanks(int[] score) {
        int size = score.length;
        String output[] = new String[size];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<size;i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                int curr = score[i];
                Stack<Integer> store = new Stack<>();
                while (!stack.isEmpty()&&score[stack.peek()]>curr){
                    store.add(stack.pop());
                }
                stack.push(i);
                while (!store.isEmpty()){
                    stack.push(store.pop());
                }
            }
        }
        int rank = 0;
        while (!stack.isEmpty()){
            int curr = stack.pop();
            if(rank==0) output[curr] = "Gold Medal";
            else if(rank==1) output[curr] = "Silver Medal";
            else if(rank==2) output[curr] = "Bronze Medal";
            else{
                String newOne = "";
                newOne +=(rank+1);
                output[curr] = newOne;
            }
            rank++;
        }
        return output;
    }
}