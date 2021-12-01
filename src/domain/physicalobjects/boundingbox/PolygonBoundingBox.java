package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;

import java.util.Arrays;

public class PolygonBoundingBox extends BoundingBox{

    private Vector[] points;
    private Vector[] edges;
    private int numEdges;

    private final int fragmentation = 5;

    //IMPORTANT!
    //While creating this class give vectors in clockwise order.
    public PolygonBoundingBox(Vector... points){
        this.numEdges = points.length;

        if(numEdges < 3)
            throw new RuntimeException("Not enough edges");

        this.points = Arrays.copyOf(points, numEdges);
        this.edges = new Vector[numEdges];


        for(int i=0; i<numEdges-1; i++)
            edges[i] = points[i+1].subtract(points[i]);

        edges[numEdges-1] = points[0].subtract(points[numEdges-1]);
    }

    public boolean isInside(Vector v){
        System.out.println(v);
        for(int i =0; i< points.length; i++){
            if(edges[i].cross(v.subtract(points[i])) < 0)
                return false;
        }

        return true;
    }

    @Override
    public boolean isCollidingWith(BoundingBox b) {
        for(int i =0; i<numEdges; i++){
            for(int j=1; j<fragmentation+1; j++){
                if(b.isInside(points[i].add(edges[i].scale(fragmentation/j))))
                    return true;
            }
        }

        return false;
    }

    @Override
    public void shift(Vector v) {
        for(int i =0; i<numEdges; i++){
            edges[i] = edges[i].add(v);
            points[i] = points[i].add(v);
        }
    }
}
