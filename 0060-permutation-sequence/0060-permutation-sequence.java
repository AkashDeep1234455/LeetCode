class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact*=i;
        }
        StringBuilder sb = new StringBuilder();
        k = k-1;
        for(int i=n;i>=1;i--){
            fact = fact/i;
            int index = k/fact;
            sb.append(numbers.get(index));
            numbers.remove(index);
            k=k%fact;
        }
        return sb.toString();
    }
}