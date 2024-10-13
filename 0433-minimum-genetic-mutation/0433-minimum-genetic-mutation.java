class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> valid = new HashSet<>();
        for(String str:bank) valid.add(str);
        if(!valid.contains(endGene)) return -1;
        StringBuilder start = new StringBuilder(startGene);
        StringBuilder end = new StringBuilder(endGene);
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int mutations = 0;
        char[] genes = new char[]{'A', 'C', 'G', 'T'};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                if(curr.equals(endGene)) return mutations;
                char arr[] = curr.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char old = arr[j];
                    for(char gene:genes){
                        arr[j] = gene;
                        String newGene = new String(arr);
                        if(valid.contains(newGene)){
                            queue.add(newGene);
                            valid.remove(newGene);
                        }
                    }
                    arr[j] = old;
                }
            }
            mutations++;
        }
        return -1;
    }
}