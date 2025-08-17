class Solution {
    public String frequencySort(String s) {
        char[]  chars= s.toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(char ch : chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>(
                (a,b) -> (b.getValue() - a.getValue())
        );

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            heap.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            Map.Entry<Character,Integer> newmap = heap.poll();
            char c = newmap.getKey();
            int freq = newmap.getValue();

            for(int i = 0; i < freq; i++){
                sb.append(c);
            }
        }

        return sb.toString();

    }
}