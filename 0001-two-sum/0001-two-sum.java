class Help{
    int value;
    HashSet<Integer> index;
    public Help(int value){
        this.value = value;
        this.index = new HashSet<>();
    }
    public void addIndex(int newIndex){
        index.add(newIndex);
    }
    public HashSet<Integer> getIndex(){
        return index;
    } 
    public int getValue(){
        return value;
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Help> map = new HashMap<>();
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).addIndex(i);
            }else{
                Help help = new Help(nums[i]);
                help.addIndex(i);
                map.put(nums[i],help);
            }
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int num1=0,num2=0,sum=0;
        while(left<right){
            sum = nums[left]+nums[right];
            if(sum==target){
                num1 =nums[left];
                num2 = nums[right];
            }
            if(sum>target) right--;
            else left++;
        }
        ///nums[i]
    int out[] = new int[2];
    Help num1help = map.get(num1);
    if (num1help == null) return null; 
    HashSet<Integer> set1 = num1help.getIndex();

    if (!set1.isEmpty()) {
        Iterator<Integer> iterator1 = set1.iterator();
        out[0] = iterator1.next();
        iterator1.remove();
    } else {
        return null; 
    }

Help num2help = map.get(num2);
if (num2help == null) return null; // Avoid NullPointerException
HashSet<Integer> set2 = num2help.getIndex(); // Fix: Fetch from num2help

if (!set2.isEmpty()) {
    Iterator<Integer> iterator2 = set2.iterator();
    out[1] = iterator2.next();
    iterator2.remove(); // Safely remove the retrieved element
} else {
    return null; // No valid index for num2
}

return out;
    }
}