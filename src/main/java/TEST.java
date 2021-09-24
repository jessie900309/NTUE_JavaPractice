public class TEST {

    public static void main(String[] args) {

        double f1 = 102.20f, f2 = 0.0f, f3 = -0.0f;
        double retval;

        retval = StrictMath.signum(f1); //102.20f
        System.out.println("Value = " + retval); // 1.0

        retval = StrictMath.signum(f2); //0.0f
        System.out.println("Value = " + retval); // 0.0

        retval = StrictMath.signum(f3); //-0.0f
        System.out.println("Value = " + retval); //-0.0

        System.out.println("Value = " + (retval+3));  // 3.0
        System.out.println("Value = " + (retval-3));  //-3.0
        System.out.println("Value = " + (retval*(3)));//-0.0
    }
}
