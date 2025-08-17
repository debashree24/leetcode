class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //max heap + hashmap + lexicograpical order result of words
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(
                (a,b) -> {
                    if(!(a.getValue()).equals(b.getValue())){
                        return (a.getValue() - b.getValue()); //so this will sort based on freq
                    }else{
                        return b.getKey().compareTo(a.getKey()); //and if freq is same it will sort lexicographically
                    }
                }
        );

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }

        List<String> result = new ArrayList();
        while(!heap.isEmpty()){
            result.add(heap.poll().getKey());
        }

        Collections.reverse(result);
        return result;
    }
}