class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 1;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(stack.isEmpty()) stack.push(num);
            else{
                if(stack.peek()==num){
                    count++;
                }else{
                    map.put(stack.peek(),count);
                    System.out.println(stack.peek()+" "+count);
                    count = 1;
                    stack.push(num);
                }
            }
            if(i==nums.length-1){
                map.put(num,count);
            }
        }
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)->map.get(b)-map.get(a)
            );
            for(int key:map.keySet()){
                pq.add(key);
            }

            int output[]= new int[k];
            int size=k;
            int index = 0;
            while(size!=0){
                output[index++] = pq.poll();
                size--;
            }
            return output;
        

    }
}