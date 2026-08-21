import java.util.Scanner;

class Reception {
    protected static Scanner sc = new Scanner(System.in);
}

class Vector extends Reception {
    private int[] num = new int[15];
    private int[] numMayProm;

    public boolean valid_number_rang(int input) {
        if (input >= 10 && input <= 100) {
            return true;
        } else {
            System.out.println("Número inválido. Debe ingresar un número entre 10 y 100.");
            return false;
        }
    }

    public void ingresarDatos() {
        boolean valid = false;
        int ent = 0;
        for (int i = 0; i < num.length; i++) {
            do {
                System.out.println("ingresa solo números entre 10 y 100: ");
                ent = sc.nextInt();
                valid = valid_number_rang(ent);
            } while (!valid);
            System.out.println("Valor ingresado para la posición [" + i + "]: " + ent + "");
            num[i] = ent;
        }
    }

    public void mostrar(boolean opc) {
        if (opc) {
            System.out.print("VECTOR ACTUAL: [ ");
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println("]");
        } else {
            System.out.print("VECTOR PROMEDIO: [ ");
            for (int i = 0; i < numMayProm.length; i++) {
                System.out.print(numMayProm[i] + " ");
            }
            System.out.println("]");
            System.out.println("hay " + numMayProm.length + " números por encima del promedio ");
        }
    }

    public void buscar(int numBuscado) {
        boolean encontrado = false;

        for (int i = 0; i < num.length; i++) {
            if (num[i] == numBuscado) {
                System.out.println("¡Lo encontré! El dato " + numBuscado + " está en el índice " + i);
                encontrado = true;
                break;
            }
        }

        if (encontrado == false) {
            System.out.println("El dato " + numBuscado + " no existe en este vector.");
        }
    }

    public void mayorMenor() {
        int mayor = num[0];
        int menor = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] > mayor) {
                mayor = num[i];
            }
            if (num[i] < menor) {
                menor = num[i];
            }
        }

        System.out.println("Número mayor encontrado: " + mayor);
        System.out.println("Número menor encontrado: " + menor);
    }

    public void buscarMultiplo(int multi) {
        System.out.println("Multiplos de " + multi + " en el vector:");

        boolean encontrado = false;
        for (int i = 0; i < num.length; i++) {
            if (num[i] % multi == 0) {
                System.out.println(num[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron múltiplos de " + multi);
        }
    }

    public int sumaVector() {
        int suma = 0;

        for (int i = 0; i < num.length; i++) {
            suma += num[0] + suma;
        }

        return suma;
    }

    public void nuevoVectorProm() {
        int tamNuevoVector = 0;
        double promedio = (double) sumaVector() / num.length;
        System.out.println("Promedio calculado: " + promedio);
        for (int i = 0; i < num.length; i++) {
            if (num[i] > promedio) {
                tamNuevoVector++;
            }
        }
        if (tamNuevoVector == 0) {
            System.out.println("por una extraña razón no se encuentra numeros mayores al promedio...");
            System.out.println("se te redirigirá el menu...");
        } else {
            numMayProm = new int[tamNuevoVector];
            for (int i = 0; i < numMayProm.length; i++) {
                if (num[i] > promedio) {
                    numMayProm[i] = num[i];
                }
            }
            mostrar(false);
        }
    }
}

public class manipulacion_vectores {
    public static void main(String[] args) {

        Scanner objEntrada = Reception.sc;
        Vector v = new Vector();
        int opcSelecc = 0;

        do {
            System.out.println("\n========= MENÚ DE OPCIONES =========");
            System.out.println("1. Llenar el Vector");
            System.out.println("2. Buscar un número en el Vector");
            System.out.println("3. Determinar el Mayor y el Menor Valor dentro del vector");
            System.out.println("4. Identificar Múltiplos de un Número");
            System.out.println("5. Calcular la Suma de Todos los Valores");
            System.out.println("6. Crear un Nuevo Vector con Números por Encima del Promedio");
            System.out.println("7. Salir");
            System.out.print("Elija su opción: ");

            opcSelecc = objEntrada.nextInt();

            switch (opcSelecc) {
                case 1:
                    v.ingresarDatos();
                    v.mostrar(true);
                    break;
                case 2:
                    System.out.print("¿qué numero desea buscar?: ");
                    int b = objEntrada.nextInt();
                    v.buscar(b);
                    break;
                case 3:
                    System.out.println("se buscará el numero mayor y menor en el vector actual.");
                    v.mayorMenor();
                    break;
                case 4:
                    System.out.println("ingresa el multiplo que se desea identificar: ");
                    int m = objEntrada.nextInt();
                    v.buscarMultiplo(m);
                    break;
                case 5:
                    System.out.println("Se calculará la suma de todos los valores actuales en el vector.");
                    System.out.println("el valor total sumado es: " + v.sumaVector());
                    break;
                case 6:
                    System.out.println("Se creará un nuevo vector calculando el promedio.");
                    v.nuevoVectorProm();
                    break;
                case 7:
                    System.out.println("Finalizando programa. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Error: Opción no válida, intente de nuevo.");
            }

        } while (opcSelecc != 7);

        objEntrada.close();
    }
}