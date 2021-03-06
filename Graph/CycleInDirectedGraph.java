package Graph;

import java.util.Set;
import java.util.HashSet;

/**
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
public class CycleInDirectedGraph {
// Solution first step is to put all the vertices into the white set.
// we do the depth first search till either we found a cycle in the graph or if we move all the white set to black
// set.
    public boolean hasCycle(Graph<Integer> graph) {

        //for unvisited set
        Set<Vertex<Integer>> whiteSet = new HashSet<>();
        //for currently visiting set
        Set<Vertex<Integer>> graySet = new HashSet<>();
        //already visited set
        Set<Vertex<Integer>> blackSet = new HashSet<>();

        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            whiteSet.add(vertex);
        }

        while (whiteSet.size() > 0) {
            Vertex<Integer> current = whiteSet.iterator().next();
            if(dfsCycleDirectedGraph(current, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsCycleDirectedGraph(Vertex<Integer> current, Set<Vertex<Integer>> whiteSet,
                                          Set<Vertex<Integer>> graySet, Set<Vertex<Integer>> blackSet ) {
        // first step :  move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
        for(Vertex<Integer> neighbor : current.getAdjacentVertexes()) {
            //if in black set means already explored so continue.
            if (blackSet.contains(neighbor)) {
                continue;
            }
            //if in gray set then cycle found.
            if (graySet.contains(neighbor)) {
                return true;
            }
            if(dfsCycleDirectedGraph(neighbor, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
    }

    private void moveVertex(Vertex<Integer> vertex, Set<Vertex<Integer>> sourceSet,
                            Set<Vertex<Integer>> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        CycleInDirectedGraph cdg = new CycleInDirectedGraph();
        System.out.println(cdg.hasCycle(graph));
    }
}
