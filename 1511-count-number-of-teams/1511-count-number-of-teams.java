class Solution {
    public int numTeams(int[] rating) {
        int noOfTeams = 0;
        int n = rating.length;
        for(int j=0;j<n;j++){
            int leftside=0,leftsidereverse=0,rightside=0,rightsidereverse=0;
            for(int i=0;i<j;i++){
                if(rating[i]<rating[j]) leftside++;
                if(rating[i]>rating[j]) leftsidereverse++;
            }
            for(int k=j+1;k<n;k++){
                if(rating[j]<rating[k]) rightside++;
                if(rating[j]>rating[k]) rightsidereverse++;
            }
            noOfTeams += leftside*rightside+leftsidereverse*rightsidereverse;
        }
        return noOfTeams;
    }
}