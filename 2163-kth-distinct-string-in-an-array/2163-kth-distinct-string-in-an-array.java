class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> mapCount = new HashMap<>();
        for (String ar : arr) {
            mapCount.put(ar, mapCount.getOrDefault(ar, 0) + 1);
        }
        for (String ar : arr) {
            if (mapCount.get(ar) == 1) {
                k--;
                if (k == 0) {
                    return ar;
                }
            }
        }
        return "";
    }
}