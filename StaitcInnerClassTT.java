package javabasestructure;

/**
 * @author Amos
 * @date 8/1/2020 10:31 AM
 */
public class StaitcInnerClassTT {
    public static void main(String[] args) {
        double[] doubles = new double[20];
        for (int i = 0; i <doubles.length ; i++) {
            doubles[i] = 100 *Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.Pair.minmax(doubles);
        System.out.println("p.getFirst() = " + p.getFirst());
        System.out.println("p.getSecond() = " + p.getSecond());
    }
}


class ArrayAlg
{
    public static class Pair{
        private double first;;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public void setFirst(double first) {
            this.first = first;
        }

        public void setSecond(double second) {
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
        public static Pair minmax(double[] values){
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double v:values
                 ) {
                if(min>v) {
                    min = v;
                }
                if(max<v) {
                    max = v;
                }
            }
            return new Pair(min,max);
        }
    }
}
