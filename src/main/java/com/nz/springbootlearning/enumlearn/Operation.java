package com.nz.springbootlearning.enumlearn;

public enum Operation {
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },

    MINS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },

    TIMES{
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    };

    public abstract double eval(double x, double y);


    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(1.1, 1.2));
        System.out.println(Operation.MINS.eval(1.3, 1.2));
        System.out.println(Operation.TIMES.eval(1.1, 1.1));

    }

}
