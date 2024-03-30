class Solution {
    public String maximumOddBinaryNumber(String s) {
        int numberOfone = 0;
        int size = s.length();
        int arr[] = new int[size];
        int noOfOne = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = s.charAt(i);
            if (s.charAt(i) == '1') numberOfone++;
        }
        if (arr[size - 1] == 0) {
            numberOfone--;
            arr[size - 1] = 1;
        } else {
            numberOfone--;
        }
StringBuilder output = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            if (numberOfone > 0) {
                arr[i] = 1;
                output.append(1);
                numberOfone--;
            } else {
                arr[i] = 0;
                output.append(0);
            }
        }
        output.append(1);
        
        return output.toString();
    }
}