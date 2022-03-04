package edu.eci.cvds.calculator;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.*;


@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
@SessionScoped
public class calculadora{

    static String cadenaEntrada = "";
    static double resultadoMean = 0;
    static double resultadoVariance = 0;
    static double resultadoStandardDeviation = 0;
    static double resultadoMode = 0;
    static double cantidadNumero = 0;


    /**
     * Metodo que transforma la cadena digitada por el usuario en cadena de Double´s
     * @return Array de Double´s
     */
    public calculadora(){}

    public static String getCadenaEntrada() {
        return cadenaEntrada;
    }

    public static double getResultadoMean() {
        return resultadoMean;
    }

    public static void setResultadoMean(double resultadoMean) {
        calculadora.resultadoMean = resultadoMean;
    }

    public static double getResultadoVariance() {
        return resultadoVariance;
    }

    public static void setResultadoVariance(double resultadoVariance) {
        calculadora.resultadoVariance = resultadoVariance;
    }

    public static double getResultadoStandardDeviation() {
        return resultadoStandardDeviation;
    }

    public static void setResultadoStandardDeviation(double resultadoStandardDeviation) {
        calculadora.resultadoStandardDeviation = resultadoStandardDeviation;
    }

    public static double getResultadoMode() {
        return resultadoMode;
    }

    public static void setResultadoMode(double resultadoMode) {
        calculadora.resultadoMode = resultadoMode;
    }

    public static double getCantidadNumero() {
        return cantidadNumero;
    }

    public static void setCantidadNumero(double cantidadNumero) {
        calculadora.cantidadNumero = cantidadNumero;
    }

    public static void setCadenaEntrada(String cadenaEntrada) {
        calculadora.cadenaEntrada = cadenaEntrada;
    }

    public void calculateValues() {
        calculateMean();
        calculateMode();
        calculateVariance();
        calculateStandardDeviation();
    }

    /**
     * Calcula promedio de los datos
     * @return Int que representa el promedio
     */
    private static double[] cadenaADouble() {
        String[] valores = cadenaEntrada.split(";");
        double[] resultadoValores = new double[valores.length];
        for (int i = 0; i<valores.length;i++) {
            resultadoValores[i]=Double.parseDouble(valores[i]);
        }
        cantidadNumero = resultadoValores.length;
        return resultadoValores;
    }

    /**
     * Calcula promedio de los datos
     */
    public static void calculateMean() {
        double[] m = cadenaADouble();
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        resultadoMean = sum / m.length;
    }

    /**
     * Calcula la varianza de los datos
     */
    public static void calculateVariance(){
        double[] m = cadenaADouble();
        double sqDiff = 0;
        double n = m.length;
        for (int i = 0; i < n; i++) {
            calculateMean();
            sqDiff += (m[i] - getResultadoMean()) * (m[i] - getResultadoMean());
        }
        resultadoVariance = sqDiff/n;
    }

    /**
     * Calcula la desviacion estandar de los datos
     * @return Int que representa la desviacion estandar
     */
    public static void calculateStandardDeviation(){
        double[] m = cadenaADouble();
        calculateVariance();
        resultadoStandardDeviation = Math.sqrt(getResultadoVariance());
    }


    /**
     * Calcula la moda de los datos
     * @return Int que representa la moda
     */
    public static double calculateMode() {
        double maxCount = 0;
        double resultadoMode=0;
        double m[] = cadenaADouble();
        double n = m.length;
        for (int i = 0; i < n; ++i) {
            double count = 0;
            for (int j = 0; j < n; ++j) {
                if (m[j] == m[i])
                    ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                resultadoMode = m[i];
            }
        }
        return resultadoMode;
    }


    /**
     * Metodo que reinicia los datos
     */
    public static void restart(){
        cadenaEntrada = "";
        resultadoMean = 0;
        resultadoVariance = 0;
        resultadoStandardDeviation = 0;
        resultadoMode = 0;
        cantidadNumero = 0;
    }



    @Override
    public String toString() {
        return "Calculadora [cadenaEntrada=" + cadenaEntrada + ", resultadoMean=" + resultadoMean
                + ", resultadoVariance=" + resultadoVariance + ", resultadoStandartDeviation="
                + resultadoStandardDeviation + ", resultadoMode=" + resultadoMode + ", cantidadNumero=" + cantidadNumero
                + "]";
    }

}