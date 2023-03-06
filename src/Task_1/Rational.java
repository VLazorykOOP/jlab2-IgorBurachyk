//   4   ||   11   ||   12   ||
/* Раціональний (нескоротний) дріб представлений парою цілих чисел (a, b), де
         a – чисельник, b – знаменник. Створити клас Rational для роботи з
         раціональними дробами. Обов’язково реалізувати операції: додавання,
         віднімання, множення, ділення, порівняння (на рівність, на більше чи менше).
         Реалізувати доступний тільки для класу Rational метод скорочення (reduce),
         який викликається при виконанні арифметичний операцій.*/
class Rational {
    int a = 2, b = 2;

    public void Print() {
        //System.out.println("A: " + a + " B: " + b);
        System.out.println("Fraction: " + a + " / " + b);
    }
    //Finding Greatest Common Denominator
    static int GCD(int n1, int n2){
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        int lcm = (n1 * n2) / gcd;
        return lcm;
    }
    //Simplifying fraction
    public void reduceFraction(int n1 , int n2){
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        a = a / gcd;
        b = b / gcd;
    }
    //Adding fractions
    public void Adding(Rational rt2){
        if (b == rt2.b) {
            a = a + rt2.a;
            b = b + rt2.b;
        }
        else{
            int lcm = GCD(b, rt2.b);
            //System.out.println("GCD: " + GCD(b, rt2.b));
            a = (a * lcm/b) + (rt2.a * lcm/ rt2.b);
            b = lcm;
            /*System.out.println("GCD: " + b);
            System.out.println("A: " + a + " B: " + b);*/
            reduceFraction(a, b);
            System.out.println("Addition was done!");
        }
    }
    //Subtracting fractions
    public void Subtracting(Rational rt2){
        if (b == rt2.b) {
            a = a - rt2.a;
            b = b - rt2.b;
        }
        else{
            int lcm = GCD(b, rt2.b);
            //System.out.println("GCD: " + GCD(b, rt2.b));
            a = (a * lcm/b) - (rt2.a * lcm/ rt2.b);
            b = lcm;
            /*System.out.println("GCD: " + b);
            System.out.println("A: " + a + " B: " + b);*/
            reduceFraction(a, b);
            System.out.println("Subtraction was done!");
        }
    }
    public void Multiplying(Rational rt2){
        b = b * rt2.b;
        a = a * rt2.a;
        reduceFraction(a, b);
        System.out.println("Multiplying was done!");
    }
    public void Dividing(Rational rt2){
        b = b * rt2.a;
        a = a * rt2.b;
        reduceFraction(a, b);
        System.out.println("Dividing was done!");
    }

    public static void main(String[] args) {
        //Checking Adding
        Rational rt = new Rational();
        rt.b = 72;
        Rational rt2 = new Rational();
        rt2.b = 120;
        rt.Adding(rt2);
        rt.Print();

        //Checking Subtracting
        Rational rt3 = new Rational();
        rt3.b = 72;
        rt3.Subtracting(rt2);
        rt3.Print();

        //Checking Multiplying
        Rational rt5 = new Rational();
        rt5.b = 72;
        rt5.Multiplying(rt2);
        rt5.Print();

        //Checking Dividing
        Rational rt7 = new Rational();
        rt7.b = 72;
        rt7.Dividing(rt2);
        rt7.Print();
    }
}