class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        if(k>=tickets.length) return 0;
        int index = 0;
        int price = 0;
        while(tickets[k]!=0){
            if(tickets[index]>0) {
                tickets[index] = tickets[index] - 1;
                price++;
            }
            index++;
            if(index==tickets.length){
                index = 0;
            }
        }
        return price;
    }
}