/* Question 4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

import java.util.LinkedList;

public class Question {
    public enum State {
        Unvisited, Visited, Visiting;
    }

    public static void main(String a[]) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    //this is a BFS way to search for the route from start to end
    //we use the LinkedList to act like the Queue in Java
    public static boolean search(Graph g, Node start, Node end) {
        LinkedList<Node> graph = new LinkedList<Node>();
        for(Node u : g.getNodes())
            u.state = State.Unvisited;
        graph.add(start);
        start.state = State.Visiting;
        while(!graph.isEmpty())
        {
            Node u = graph.removeFirst();
            if(u != null)
            {
                for(Node v: u.getAdjacent())
                {
                    if(v.state == State.Unvisited)
                    {
                        if(v==end)
                            return true;
                        else
                        {
                            graph.add(v);
                            v.state = State.Visiting;
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}

