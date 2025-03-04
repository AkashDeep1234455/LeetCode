class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(1);
        output.add(first);
        if(numRows==1) return output;

        for(int i=2;i<=numRows;i++){
            List<Integer> input = new LinkedList<>();
            for(int j=0;j<i;j++){
                if(j==0) input.add(1);
                else if(j==i-1) input.add(1);
                else{
                List<Integer> previous = output.get(i-2);
                int val = previous.get(j)+previous.get(j-1);
                input.add(val);
                }
            }
            output.add(input);
        }


        return output;
    }
}