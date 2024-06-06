class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
          int handLength = hand.length;
        if(handLength%groupSize!=0) return false;
        int noOfgroups = handLength/groupSize; 
        Arrays.sort(hand);
        boolean visited[] = new boolean[handLength];
        int noOfgroupFormed = 0;
        for(int i=0;i<handLength;i++){
            int curr = hand[i];
            int requiredSize = groupSize-1;
            int searchIndex = i+1;
            int numToSearch = curr+1;
            if(!visited[i]) {
                while (requiredSize != 0) {
                    visited[i] = true;
                    for (int j = searchIndex; j < handLength; j++) {
                        if (hand[j] == numToSearch && !visited[j]) {
                            numToSearch++;
                            visited[j] = true;
                            searchIndex = j + 1;
                            break;
                        } else if (hand[j] > numToSearch) {
                            return false;
                        }
                    }
                    requiredSize--;
                }
                noOfgroupFormed++;
            }
        }
        if(noOfgroupFormed!=noOfgroups) return false;
        return true;
    }
}