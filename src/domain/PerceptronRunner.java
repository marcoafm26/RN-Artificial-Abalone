package domain;

import app.Perceptron;

import java.util.Arrays;

public class PerceptronRunner {
    private static double[][][] baseE = new double[][][]{
            {{0,0},{0}},
            {{0,1},{0}},
            {{1,0},{0}},
            {{1,1},{1}},
    };

    public static void main(String[] args) {
        
        final int QTD_IN = 2;
        final int QTD_OUT= 1;
        final double U = 0.1;
        final int EPOCA = 1000;

        Perceptron p = new Perceptron(QTD_IN,QTD_OUT,U);
        
        double erroEp = 0;
        double erroAm = 0;

        for (int e = 0; e < EPOCA; e++) {
            erroEp = 0;

            for (int a = 0; a < baseE.length; a++) {
                double[] x = baseE[a][0];
                double[] y = baseE[a][1];
                double[] out = p.learn(x,y);
                erroAm = somador(y,out);
                erroEp += erroAm;
            }
                imprimir(erroEp,e);
        }
    }

    public static double somador(double[] y, double[] out){
        double soma=0;
        for (int i = 0; i < y.length; i++) {
            soma+=Math.abs(y[i]-out[i]);
        }
        return soma;
    }

    public static void imprimir(double erroEp, int epoca){
        System.out.println("Epoca "+(epoca+1)+"   erro: "+erroEp);
    }
}
