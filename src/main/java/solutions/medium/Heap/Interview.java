/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you're in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/

public class MyClass {
    public static void main(String args[]) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        //return k most frequent elements in nums
        Map<Integer,Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int maxfreq = 0;
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
            maxfreq = Math.max(maxfreq, freq.get(num));
        }

        //simulate bucket sort > hashmap internal structure
        Map<Integer,List<Integer>> bucket = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            bucket.putIfAbsent(entry.getValue(), new ArrayList<>(entry.getKey()));
        }

        while(k > 0){
            for(int i = maxfreq; i > 0 ; i--){
                int size = bucket.get(i).size();
                if(size <= k){
                    ans.addAll(bucket.get(i));
                }else{
                    ans.addAll(bucket.get(i).subList(0,k));
                }
                k -= size;
            }
        }
        System.out.println(ans);
    }
}