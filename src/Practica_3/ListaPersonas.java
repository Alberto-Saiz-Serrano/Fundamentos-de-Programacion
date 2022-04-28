package Practica_3;

public class ListaPersonas {
    private int numPersona;
    private static final int MAX_PERSONA = 10;
    private final Persona[] lpersona;

    public ListaPersonas() {
        lpersona = new Persona[MAX_PERSONA];
        numPersona = 0;
    }

    public int getNumPersona() {
        return numPersona;
    }
    public Persona[] getLpersona() {
        return lpersona;
    }

    public Persona getPersona(String nombre) {
        Persona pers = null;
        int x = 0;
        while (x < lpersona.length && x < numPersona) {
            if (lpersona[x].getNombre().equals(nombre)) {
                pers = lpersona[x];
            }
            x++;
        }
        return pers;
    }

    public Persona getPersona(int posicion) {
        return lpersona[posicion];
    }

    public void addPersona(Persona persona) {
        if (numPersona >= MAX_PERSONA) {
            System.out.println("No se pueden añadir más personas");
        } else {
            lpersona[numPersona] = persona;
            numPersona++;
        }
    }

    public void mostrarListaPersonas() {
        for (int x = 0; x < numPersona; x++) {
            System.out.printf("%d. %s\n", x + 1, lpersona[x].toString());
        }
    }

    public void eliminarListaPersonas(String nombre) {
        boolean resultado = false;
        int x = 0;
        while (x < numPersona && !resultado) {
            if (lpersona[x].getNombre().equals(nombre)) {
                lpersona[x] = lpersona[x + 1];
                for (int i = x + 1; i < numPersona; i++) {
                    lpersona[i] = lpersona[i + 1];
                }
                numPersona--;
                resultado = true;
            }
            x++;
        }
    }

    public boolean comprobarRepeticionNombre(String nombre) {
        return getPersona(nombre) != null;
    }
}
