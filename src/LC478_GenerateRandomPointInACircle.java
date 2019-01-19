public class LC478_GenerateRandomPointInACircle {
    private double radius;
    private double x_center;
    private double y_center;

    public LC478_GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double x_min = x_center - radius;
        double y_min = y_center - radius;
        double x = x_min + 2*radius * Math.random();
        double y = y_min + 2*radius * Math.random();
        while(!validate(x, y)){
            x = x_min + 2*radius * Math.random();
            y = y_min + 2*radius * Math.random();
        }
        return new double[]{x, y};
    }

    private boolean validate(double x, double y){
        return (x-x_center)*(x-x_center) + (y-y_center) *(y-y_center) <= radius * radius;
    }
}
