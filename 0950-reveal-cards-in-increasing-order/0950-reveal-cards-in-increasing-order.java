class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int decks:deck){
            pq.add(decks);
        }
        Queue<Integer> output = new LinkedList<>();
        while(output.size()!=deck.length){
            if(output.size()==0||output.size()==1){
                int currValue = pq.poll();
                output.add(currValue);
            }else{
                int topValue = output.poll();
                output.add(topValue);
                int currValue = pq.poll();
                output.add(currValue);
            }
        }

        for(int i=deck.length-1;i>=0;i--){
            deck[i] = output.poll();
        }
        return deck;
    }
}