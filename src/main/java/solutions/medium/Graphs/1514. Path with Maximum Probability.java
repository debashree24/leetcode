class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //difference to classic djikstras is we maximize the relexation at every node

        //1) creating adj list with double as we have to hold probabilities
        List<List<double[]>> adj = new ArrayList();
        for(int i=0; i < n; i++){
            adj.add(new ArrayList());
        }
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            adj.get(a).add(new double[]{b, prob});
            adj.get(b).add(new double[]{a, prob});
        }

        double[] maxtimes = djikstras(n, start_node, adj);
        return maxtimes[end_node];
    }

    private double[] djikstras(int n, int start, List<List<double[]>> adj){

        //Creating max heap //
        PriorityQueue<double[]> heap = new PriorityQueue<double[]>(
                (a,b) -> Double.compare(b[1],a[1]) // comparator by default accepts int so we need to specify double and cant minus here
        );

        //probability array
        double[] probs = new double[n];
        Arrays.fill(probs,0.0);// in case of max probability always initialize with the min value
        probs[start] = 1.0; //because the probability of reaching the start is 100%
        heap.offer(new double[]{start,1.0});

        while(!heap.isEmpty()){
            double[] pair = heap.poll();
            int u = (int) pair[0]; // node is always integer
            double probability = pair[1];
            if(probability < probs[u]) continue;
            for(double[] neighbor : adj.get(u)){
                int v = (int) neighbor[0]; //node is always integer
                double w = neighbor[1];
                if(probs[u] * w > probs[v]){ //since we are maximising, in relaxtion we multiply
                    probs[v] = probs[u] * w;
                    heap.offer(new double[]{v,probs[v]});
                }
            }
        }
        return probs;
    }
}