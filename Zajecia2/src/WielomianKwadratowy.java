class WielomianKwadratowy {
     double a;
     double b;
     double c;

     WielomianKwadratowy(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }



     WielomianKwadratowy dodaj(WielomianKwadratowy innyWielomian) {
        double noweA = this.a + innyWielomian.a;
        double noweB = this.b + innyWielomian.b;
        double noweC = this.c + innyWielomian.c;
        return new WielomianKwadratowy(noweA, noweB, noweC);
    }


    WielomianKwadratowy roznica(WielomianKwadratowy innyWielomian){
        double noweA = this.a - innyWielomian.a;
        double noweB = this.b - innyWielomian.b;
        double noweC = this.c - innyWielomian.c;
        return new WielomianKwadratowy(noweA,noweB,noweC);
    }

    static int[] mnozenieW(int[] W1, int[] W2) {
        int m = W1.length;
        int n = W2.length;
        int[] result = new int[m + n - 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i + j] += W1[i] * W2[j];
            }
        }

        return result;
    }


     double[] miejscaZerowe() {
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{x1, x2};
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            return new double[]{x0};
        } else {
            return new double[]{};
        }
    }
}