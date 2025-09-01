class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //cards in every group has to be consecutive cards.
        int n = hand.length;
        if(n%groupSize != 0) return false; //can't even be grouped

        //ceate a freq map
        TreeMap<Integer,Integer> freq = new TreeMap(); //to store counts of card in incremental fashion
        for(int card : hand){
            freq.put(card,freq.getOrDefault(card,0)+1);
        }

        while(!freq.isEmpty()){
            int first = freq.firstKey();//always picking the card with the smallest hand
            for(int card=first; card < first + groupSize; card++){
                if(!freq.containsKey(card)){
                    return false;
                }
                int count = freq.get(card);
                if(count == 1){
                    freq.remove(card);
                }else{
                    freq.put(card,count-1);
                }
            }
        }
        return true;
    }
}