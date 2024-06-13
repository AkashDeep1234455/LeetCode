class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
       Arrays.sort(seats);
        Arrays.sort(students);
        int totalMove = 0;
        for(int i=0;i<students.length;i++){
            totalMove +=Math.abs(students[i]-seats[i]);
        }
        return totalMove;
    }
}