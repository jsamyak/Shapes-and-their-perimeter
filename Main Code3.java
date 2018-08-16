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
  public String getFileWithLargestPerimeter() {
        double largest = 0;
        File temp =null ;  
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (largest < length) {
                largest = length;
                temp = f;
            }
        }
        return temp.getName();
    }
        public void testPerimeterMultipleFilename() {
        String filename = getFileWithLargestPerimeter();
        System.out.println("Largest Perimeter file =" +filename);
    }
    
    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeterMultipleFilename();
    }
}
