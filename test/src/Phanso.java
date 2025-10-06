public class Phanso {

    /**
     * phan so.
     */
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * dat mau.
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }

    public Phanso() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * constructor.
     */
    public Phanso(int numerator, int denominator) {
        if (denominator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * rut gon.
     */
    public void reduce() {
        int ucln = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= ucln;
        denominator /= ucln;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * cong.
     */
    public Phanso add (Phanso other) {
        numerator =  numerator * other.denominator + other.numerator * denominator;
        denominator = denominator * other.denominator;
        reduce();
        return this;
    }

    /**
     * tru.
     */
    public Phanso subtract (Phanso other) {
        numerator =  numerator * other.denominator - other.numerator * denominator;
        denominator = denominator * other.denominator;
        reduce();
        return this;
    }

    /**
     * nhan.
     */
    public Phanso multiply (Phanso other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        reduce();
        return this;
    }

    /**
     * chia.
     */
    public Phanso divide (Phanso other) {
        if (other.numerator == 0) {
            return new Phanso(this.numerator, this.denominator);
        }
        numerator *= other.denominator;
        denominator *= other.numerator;
        reduce();
        return this;
    }

    /**
     * so sanh.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Phanso) {
            Phanso other = (Phanso) obj;
            Phanso c1 = new Phanso(this.numerator, this.denominator);
            Phanso c2 = new Phanso(other.numerator, other.denominator);
            c1.reduce();
            c2.reduce();
            return c1.numerator == c2.numerator && c1.denominator == c2.denominator;
        } else {
            return false;
        }
    }
}
