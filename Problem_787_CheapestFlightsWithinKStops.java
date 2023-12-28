/* 
There are n cities connected by some number of flights. 
You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/

class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      // prices array
      int[] prices = new int[n];
      Arrays.fill(prices, Integer.MAX_VALUE);
      prices[src] = 0; // it takes a price of 0 to get to the source node

      // iterate through the loop k+1 times
      for(int i=0; i<=k; i++){
         int[] temp_price = new int[n];
         for(int j=0; j<n; j++){ // populate temp with prices array
            temp_price[j] = prices[j];
         }

         // go thru every single edge
         for(int[] edge: flights){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            // NOTE: we go through the edges list k+1 times --> each time represents a layer in BFS search
               // we need this condition because we can't reach some nodes in particular layers, e.g. the first layer of BFS
            // special case: if this start node is impossible to reach (price located at start node is infinity)
            // this means we can't even reach this start node so don't check these edges
            if(prices[start] == Integer.MAX_VALUE){
               continue;
            }

            // the other condition is if we found a new shortest path to the destination node end
            // prices[start] = price to reach start and weight = price of edge connecting start to end
               // if prices[start] + weight is smaller than the current price to reach the destination node, update it
               // compare it with temp_prices because it's possible we updated temp multiple times in the loop
            if(prices[start] + weight < temp_price[end]){
               temp_price[end] = prices[start] + weight;
            }
         }

         // update prices with temp array
         for(int m=0; m<n; m++){
            prices[m] = temp_price[m];
         }
      }

      if(prices[dst]==Integer.MAX_VALUE){
         return -1;
      }

      return prices[dst];
   }
}

// Bellman-Ford, since we have at most k stops
// TC: O(e*k), e=number of edges, k=input parameter
    // similar to BFS approach; in general, Bellman Ford runs in O(e*v), e edges and v vertices

// Bellman-Ford, can deal with negative weights (Dijkstra can't)
// e.g.
    // start at source node, and do a BFS (what's the first layer of nodes we can reach within 1 stop)
    // doing BFS, we simultaneously keep track for each node we visit, what is the minimum price it takes to reach that node
        // start with an array with each entry representing the price it takes to reach that node
        
        /*

        src = A, dst = C
        price array:   A    B     C
                       0   100   500 --> turns to 0 100 200 (explain why)

        temp array:    A    B     C
                       0   100   200

        */

        /* Graph 
                A
        100  ↙    ↘ 500
            B  ->  C
               100
        */

    // the min cost to reach A from A is 0; initialize all the others with infinity
    // we go through every edge in the graph

    // 1st edge we look at: A->B is 100; we can reach B along that edge - did we find a new min path to reach node B
        // the new value in the price array will be the price it took to get to A + price it took to get to B (0+100)
        // NOTE: update the temp prices array if smaller than current price in price array
            // once we've completely updated the temp array, we put all the values in the new prices array
    
    // 2nd edge: A->C is 500; we reach C along this edge (0+500), we found a way to get to node C with cost 500
        // update temp prices array if smaller than current price in price array, 500 < inf so update temp

    // IMPORTANT:
    // before BFS, the OG price array is what we had: [0 inf inf]
    // AFTER doing the first layer of BFS, we have the temp (smallest price to pay to reach each of the nodes)
        // How many layers are we gonna do? since k=1, we will do k+1 layers --> so we do 1 more layer of BFS
    
    // replace the OG array with temp array 
        // so what we do is update our temp array and after each layer in BFS, then we replace the OG array with temp 
        // update temp array k+1 times

    // AFTER UPDATE OG ARRAY WITH TEMP ARRAY
        // we look at how much it takes to C from B
        // it takes 100 to get to B (according to price array), and it takes 100 to get to C from B so 100+100 = 200
        // IMPORTANT: is 200 smaller than what we currently have for C in our price array (500)? Yes, so update temp array
        // temp array was [0 100 500]; after updating, it is [0 100 200]
            // 200 is the cost to reach C if we add an extra stop in between
        // we went thru every single edge and now we update price array with temp array
            // price array was [0 100 500]; after updating with temp array, it is now [0 100 200]

        // after, we are done with the loop because we ran it k+1 times already
            // return 200

