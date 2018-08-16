import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        Point prevPt = s.getLastPoint();
        int count = 0;
        for (Point currPt : s.getPoints()) {
            count = count + 1;
            prevPt = currPt;
    }
        return count;
    }

    public double getAverageLength(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        int count = 0;
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
            count = count + 1;
        }
        double averageLength = totalPerim / count;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide=0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(largestSide < currDist) {
              largestSide = currDist;   
            }
            prevPt = currPt;
            }
        return largestSide;
}

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int count = getNumPoints(s);
        double avglength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        System.out.println("Perimeter = " + length);
        System.out.println("Number of points = " + count);
        System.out.println("Average Length =" + avglength);
        System.out.println("Largest Side =" + largestSide);
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
