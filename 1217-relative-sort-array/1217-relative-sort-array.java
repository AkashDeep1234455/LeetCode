class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int index = 0;
        for(int num:arr2){
            while (map.get(num)!=0){
                arr1[index] = num;
                index++;
                map.put(num,map.get(num)-1);
            }
        }
        ArrayList<Integer> set = new ArrayList<>();
        for(int key:map.keySet()){
            int count = map.get(key);
            while (count!=0){
                set.add(key);
                count--;
            }
        }
        Collections.sort(set);
        for(int num:set){
            arr1[index++] = num;
        }
        return arr1;
    }
}