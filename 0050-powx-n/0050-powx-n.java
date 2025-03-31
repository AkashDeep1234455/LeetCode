class Solution {
    public double myPow(double x, int n) {
        long N =n;
        if(N<0){
            x=1/x;
            N = -N;
        }
        double output = 1;
        while(N>0){
            if(N%2==1) output = output*x;
            x =x*x;
            N=N/2;
            System.out.println(N);
        }
        return output;
    }
}