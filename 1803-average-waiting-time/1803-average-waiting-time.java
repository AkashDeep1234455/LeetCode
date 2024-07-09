class Solution {
    public double averageWaitingTime(int[][] customers) {
         int endTime = customers[0][0]+customers[0][1];
        double totalWaitTime = customers[0][1];
        for(int i=1;i<customers.length;i++){
            int currCustomer[] = customers[i];
            if(currCustomer[0]<=endTime){
                int timeLeftForTurn = endTime - currCustomer[0];
                totalWaitTime+=(timeLeftForTurn+currCustomer[1]);
                endTime = currCustomer[1]+currCustomer[0]+timeLeftForTurn;
            }else{
                endTime = currCustomer[0]+currCustomer[1];
                totalWaitTime +=currCustomer[1];
            }
        }

        return (totalWaitTime/customers.length);
    }
}