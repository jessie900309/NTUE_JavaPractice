public class TEST {

    public static void main(String[] args) {

        double f1 = 102.20f, f2 = 0.0f, f3 = -0.0f;

        // returns 1.0 if the argument is greater than zero
        double retval = StrictMath.signum(f1);
        System.out.println("Value = " + retval);

    /* if the argument is positive zero, then the result is the
    same as the argument */
        retval = StrictMath.signum(f2);
        System.out.println("Value = " + retval);

    /* if the argument is negative zero, then the result is the
    same as the argument */
        retval = StrictMath.signum(f3);
        System.out.println("Value = " + retval);

        System.out.println("Value = " + (retval+3));
        System.out.println("Value = " + (retval-3));
        System.out.println("Value = " + (retval*(3)));
    }
}
