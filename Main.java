import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el numero de filas");
        int filas = sc.nextInt();
        System.out.println("Escriba el numero de columnas");
        int columnas = sc.nextInt();
        int numFilas = 0;
        int numColumnas = 0;
        String bodega[][] = new String[filas][columnas];
        List caminoList = new List();
        while(numFilas != filas){
            System.out.println("Escriba la " + (numFilas+1) + " fila");
            String fila = System.console().readLine();
            String[] datos = fila.split(" ");
            for (String dato: datos){
                if(dato.equals("m")){
                    String ubicacionMontacargas= "[" + numFilas + "," + numColumnas + "]";
                    caminoList.insertHead(ubicacionMontacargas);
                }
                else if(dato.equals("e")){
                    String ubicacionEntrega = "[" + numFilas + "," + numColumnas + "]";
                    caminoList.insertTail(ubicacionEntrega);
                }
                bodega[numFilas][numColumnas] = dato;
                numColumnas ++;
            }
            numColumnas = 0;
            numFilas ++;
        }
        tomarCamino(caminoList.head,bodega);

        System.out.println ("Camino a tomar:");
        System.out.println (caminoList.toString());
    }

    public static void tomarCamino(ListNode head,String[][] bodega) {
        String cordenadasString = head.getObject().toString();
        String[]cordenada = cordenadasString.split(",");
        int fila=Integer.parseInt(cordenada[0].replace("[", ""));
        int columna=Integer.parseInt(cordenada[1].replace("]", ""));
        verificarEspacioVacio(fila, columna, bodega);
    }
    public static void verificarEspacioVacio(int fila,int columna,String[][] bodega) {
        if(fila == 0 && columna == 0){
            if(bodega.length > 1){
                if(bodega[fila+1][columna].equals("0")){
                    System.out.println ("puede pasar");
                }
            }
            if(bodega[0].length > 1){
                if(bodega[fila][columna+1].equals("0")){
                    System.out.println ("puede pasar");
                }
            }
        }
        if(columna != 0){
            if(bodega[fila][columna-1].equals("0")){
                System.out.println ("puede pasar");
            }
            if(bodega[fila][columna+1].equals("0")){
                System.out.println ("puede pasar");
            }
        }
        if(fila != 0){
            if(bodega[fila-1][columna].equals("0")){
                System.out.println ("puede pasar");
            }
            if(bodega[fila+1][columna].equals("0")){
                System.out.println ("puede pasar");
            }
        }
    }
}