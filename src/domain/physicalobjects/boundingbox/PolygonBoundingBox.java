package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.Collision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonBoundingBox extends BoundingBox{

    private Vector[] points;
    private Vector[] edges;
    private int numEdges;

    private final int fragmentation = 30;

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

    public Collision getPointCollision(Vector v){
        double smallestDist = Double.MAX_VALUE;
        Vector closestEdge = null;

        for(int i =0; i< points.length; i++){
            double crossValue = edges[i].crossForBoundingBox(v.subtract(points[i]));
            if(crossValue < 0){
                return null;
            }else{
                if(crossValue < smallestDist) {
                    smallestDist = crossValue;
                    closestEdge = edges[i];
                }
            }
        }
        return new Collision(v, closestEdge.rotate(Math.PI/2).reverse().norm());
    }

    @Override
    public Collision getCollisionWith(BoundingBox b) {
        for(int i =0; i<numEdges; i++){
            for(double j=1; j<fragmentation+1; j++){
                Vector p = points[i].add(edges[i].scale(j/fragmentation));
                Collision col = b.getPointCollision(p);
                if(col != null)
                    return col;
            }
        }
        return null;
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
