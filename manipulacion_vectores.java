import java.util.Scanner;

class Reception {
    protected static Scanner sc = new Scanner(System.in);
}

class Vector extends Reception {
    private int[] num = new int[5];

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
                System.out.print("ingresa solo números entre 10 y 100: ");
                ent = sc.nextInt();
                valid = valid_number_rang(ent);
            } while (!valid);
            System.out.print("Valor ingresado para la posición [" + i + "]: " + ent + "");
            num[i] = ent;
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
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

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