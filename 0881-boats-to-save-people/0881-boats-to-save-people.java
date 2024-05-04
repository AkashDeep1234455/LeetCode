class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int length = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int ans = 0;
        while (left<=right){
            int leftWeight = people[left];
            int rightWeight = people[right];
            if(left==right) {
                ans++;
                break;
            }
            if(leftWeight+rightWeight<=limit){
                left++;
              
            }
              right--;
              ans++;
        }
        return ans;
    }
}