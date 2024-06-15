class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
          PriorityQueue<int[]> minCapital = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0;i<capitals.length;i++) minCapital.add(new int[]{capitals[i],profits[i]});

        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i=0;i<k;i++){
            while (!minCapital.isEmpty()&&minCapital.peek()[0]<=w){
                maxProfit.add(minCapital.poll());
            }
            if(maxProfit.isEmpty()) break;

            w+=maxProfit.poll()[1];
        }
        return w;
    }
}