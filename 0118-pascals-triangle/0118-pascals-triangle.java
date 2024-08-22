class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new LinkedList<>();
        if(numRows==0) return output;
        for(int i=1;i<=numRows;i++){
                List<Integer> newEntry = new LinkedList<>();
                List<Integer> match=new LinkedList<>();
                if(i!=1&&i!=2){
                    match = output.get(i-2);
                }
                for(int j=0;j<i;j++){
                    if(j==0){
                        newEntry.add(1);
                    }else if(j==i-1){
                        newEntry.add(1);
                    }else{
                        int entry = match.get(j)+match.get(j-1);
                        newEntry.add(entry);
                    }
                }
                output.add(newEntry);
        }
        return output;
    }
}