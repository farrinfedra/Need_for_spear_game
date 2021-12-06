package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonBoundingBox extends BoundingBox{

    private Vector[] points;
    private Vector[] edges;
    private int numEdges;

    private final int fragmentation = 1;

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
        for(int i =0; i< points.length; i++){
            if(edges[i].crossForBoundingBox(v.subtract(points[i])) < 0){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isCollidingWith(BoundingBox b) {
        for(int i =0; i<numEdges; i++){
            for(double j=1; j<fragmentation+1; j++){
                if(b.isInside(points[i].add(edges[i].scale(j/fragmentation))))
                    return true;
            }
        }
        return false;
    }

    @Override
    public BoundingBox shift(Vector v) {
        for(int i =0; i<numEdges; i++){
            points[i] = points[i].add(v);
        }
        return this;
    }
    @Override
    public PolygonBoundingBox deepCopy(){
        return new PolygonBoundingBox(this.points);
    }

    @Override
    public List<Vector> getFragmentation() {
        ArrayList<Vector> fragmentationList = new ArrayList<>();

        for(int i =0; i<numEdges; i++){
            for(double j=1; j<fragmentation+1; j++){
               fragmentationList.add(points[i].add(edges[i].scale(j/fragmentation)));
            }
        }

        return fragmentationList;
    }
}