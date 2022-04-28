package Practica_3;

public class Persona {
    private final String nombre;
    private final char genero;
    private final int edad;
    private final double altura;
    private final double peso;
    private double imc;
    private String estado;

    public Persona(String nombre, char genero, int edad, double altura, double peso) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        estado = calcularIMC();
    }

    public String getNombre() {
        return nombre;
    }
    public char getGenero() {
        return genero;
    }
    public int getEdad() {
        return edad;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    public double getImc() {
        return imc;
    }
    public String getEstado() {
        return estado;
    }


    //Métodos estáticos

    public static boolean comprobarNombre(String nombre){
        return nombre.contains("0") || nombre.contains("1") || nombre.contains("2") || nombre.contains("3") || nombre.contains("4") || nombre.contains("5") || nombre.contains("6") || nombre.contains("7") || nombre.contains("8") || nombre.contains("9");
    }
    public static boolean comprobarGenero(char genero){
        return (genero != 'h' && genero != 'H' && genero != 'm' && genero != 'M');
    }
    public static boolean comprobarEdad(int edad){
        return (edad <= 0 || edad > 110);
    }
    public static boolean comprobarAltura(double altura){
        return (altura < 0 || altura > 2.5);
    }
    public static boolean comprobarPeso(double peso){
        return (peso < 0 || peso > 250);
    }

    private String calcularIMC(){

        imc = peso / (Math.pow(altura, 2));
        imc = Math.round(imc*100.0)/100.0;

        if(imc < 18){
            estado = "Delgadez";
        }else if(imc >= 18 && imc < 25){
            estado = "Peso Ideal";
        }else if(imc >= 25 && imc < 30){
            estado = "Sobrepeso";
        }else{
            estado = "Obesidad";
        }
        return estado;
    }

    public String toString(){ //Función para dar un formato a
        return "Persona{ \"nombre\" = " + nombre + " , \"género\" = " + genero + " , \"edad\" = " + edad + " , \"altura\" = " + altura + " , \"peso\" = " + peso + " , \"imc\" = " + imc + " , \"estado\" = " + estado + " }";
    }
    public String toStringFichero(){
        return nombre + ";" + genero + ";" + edad + ";" + altura + ";" + peso + "\n";
    }
}
