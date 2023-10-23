 class Wektor {
    private double x;
    private double y;
    private double z;
//SET
     Wektor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

//    GET
     double getX() {
        return x;
    }


     double getY() {
        return y;
    }

     double getZ() {
        return z;
    }


     Wektor dodaj(Wektor innyWektor) {
        double newX = this.x + innyWektor.getX();
        double newY = this.y + innyWektor.getY();
        double newZ = this.z + innyWektor.getZ();
        return new Wektor(newX, newY, newZ);
    }

     Wektor iloczynWektorowy(Wektor innyWektor) {
        double newX = this.y * innyWektor.getZ() - this.z * innyWektor.getY();
        double newY = this.z * innyWektor.getX() - this.x * innyWektor.getZ();
        double newZ = this.x * innyWektor.getY() - this.y * innyWektor.getX();
        return new Wektor(newX, newY, newZ);
    }


     public Wektor iloczynSkalarny(Wektor innyWektor) {
        return new Wektor (this.x * innyWektor.getX() ,this.y * innyWektor.getY() , this.z * innyWektor.getZ());

    }


     double dlugosc() {
        return Math.sqrt(x * x + y * y + z * z);
    }


     public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}