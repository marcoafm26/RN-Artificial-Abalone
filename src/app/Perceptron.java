    package app;

    import java.util.Random;

    public class Perceptron {
        private double u;
        private int qtdIn;
        private int qtdOut;
        private double[][] w;

        private double interA=-0.2;
        private double interB=0.2;




        public Perceptron(int qtdIn,int qtdOut,double u){
            this.u=u;
            this.qtdIn =qtdIn;
            this.qtdOut=qtdOut;
            w = new double[qtdIn+1][qtdOut];
            gerarRandomW();
        }

        public double[] learn(double[] xIn,double[] y){
            double[] x = fill(xIn);
            double[] out = new double[y.length];
            x[x.length-1] = 1;
            for (int j = 0; j < y.length; j++) {
                double u = 0;
                for (int i = 0; i < x.length; i++) {
                    u+=x[i] * w[i][j];
                }
                out[j] = sigmoid(u);
            }

            for (int j = 0; j < y.length; j++) {
                for (int i = 0; i < x.length; i++) {
                    w[i][j] += u * (y[j]-out[j]) * x[i];
                }
            }
        return out;
        }
        
        private double[] fill(double[] x){
            double [] x_new = new double[x.length+1];
            for (int i = 0; i < x.length; i++) {
                x_new[i] = x[i];
            }
            x_new[x_new.length-1]=1;
            return x_new;
        }
        private void gerarRandomW() {
            Random random = new Random();
            for (int i = 0; i < w.length; i++) {
                for (int j = 0; j < w[0].length ; j++) {
                    w[i][j]= random.nextDouble(this.interA,this.interB);
                }
            }
        }

        private double sigmoid(double u){
            double value = 1/(1+Math.exp(-u));
            return value;
        }
    }

