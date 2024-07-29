class Solution {
    public int numTeams(int[] rating) {
        int noOfTeams = 0;
        int n = rating.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((rating[i]<rating[j])&&(rating[j]<rating[k])&&(rating[k]>rating[i])) {
                        noOfTeams++;
                    }
                    if((rating[i]>rating[j])&&(rating[j]>rating[k])&&(rating[i]>rating[k])){
                        noOfTeams++;
                    } 
                }
            }
        }
        return noOfTeams;
    }
}