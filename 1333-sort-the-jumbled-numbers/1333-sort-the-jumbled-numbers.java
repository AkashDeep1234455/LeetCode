class Pair {
        int mappedValue;
        int originalValue;

        Pair(int mappedValue, int originalValue) {
            this.mappedValue = mappedValue;
            this.originalValue = originalValue;
        }
}

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int output[] = new int[nums.length];
        Pair mapped[] = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            String curr = Integer.toString(nums[i]);
            StringBuilder input = new StringBuilder();
            for(int j=0;j<curr.length();j++){
                int index = (int)(curr.charAt(j))-'0';
                input.append(mapping[index]);
            }
            String inputVal = input.toString();
            int number = Integer.parseInt(inputVal);
            mapped[i] = new Pair(number,nums[i]);
        }
        Arrays.sort(mapped, Comparator.comparingInt(pair -> pair.mappedValue));
        for (int i = 0; i < mapped.length; i++) {
            output[i] = mapped[i].originalValue;
        }
        return output;
    }
}