class Solution {
    public boolean isHappy(int n) {

        //the main purpose of set is for cycle detection
        Set<Integer> set = new HashSet();
        while(n !=1 && !set.contains(n)){
            set.add(n);
            n = sumofsquares(n);
        }
        return n==1;
    }

    private int sumofsquares(int n){
        int sum = 0;
        while(n > 0){
            sum = sum + (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
}