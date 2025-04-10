class Solution {
    public void helper(int[]nums,HashSet<Integer> visited,List<List<Integer>> output,List<Integer> input,int n){
        if(input.size()==n){
            output.add(new ArrayList<>(input));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                visited.add(i);
                input.add(nums[i]);
                helper(nums,visited,output,input,n);
                visited.remove(i);
                input.remove(input.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums,new HashSet<>(),output,new ArrayList<>(),nums.length);
        return output;

    }
}