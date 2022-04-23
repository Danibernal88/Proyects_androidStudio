package models;

public class IMC_MODEL {

    private float altura;
    private float peso;

    public IMC_MODEL(float altura, float peso){
        this.altura = altura;
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float calcularIMC(float altura, float peso){
        return (peso/(altura*altura));
    }


}
