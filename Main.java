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
        tomarCamino(caminoList,bodega);

        System.out.println (caminoList.toString());
    }

    public static void tomarCamino(List caminoList,String[][] bodega) {
        String cordenadasString = caminoList.head.getObject().toString();
        String[]cordenada = cordenadasString.split(",");
        int fila=Integer.parseInt(cordenada[0].replace("[", ""));
        int columna=Integer.parseInt(cordenada[1].replace("]", ""));
        String camionoString = verificarEspacioVacio(fila, columna, bodega);
        String[]cordenadas = camionoString.split(",");
        int pos = 1;
        caminoList.clear();
        for (int i = 0; i < (cordenadas.length/2); i++) {
            caminoList.add("[" + cordenadas[pos] + "," + cordenadas[pos+1] + "]");
            pos += 2;
        }
    }
    public static String verificarEspacioVacio(int fila,int columna,String[][] bodega) {
        String camionoString = new String();
        camionoString = camionoString + "," + fila + "," + columna;
        if(fila == 0 || columna == 0){
            if(bodega.length > 1 && fila < bodega.length - 1){
                if(bodega[fila+1][columna].equals("e")){
                    return camionoString + "," + (fila+1) + "," + columna;
                }
                else if(bodega[fila+1][columna].equals("0")){
                    return camionoString + verificarEspacioVacio((fila+1), columna, bodega);
                }
                
            }
            if(bodega[0].length > 1 && columna < bodega[0].length - 1){
                if(bodega[fila][columna+1].equals("e")){
                    return camionoString + "," + fila + "," + (columna+1);
                }
                else if(bodega[fila][columna+1].equals("0")){
                    return camionoString + verificarEspacioVacio(fila, (columna+1), bodega);
                }
            }
        }
        if(columna != 0  && columna < bodega[0].length){
            if(bodega[fila][columna-1].equals("e")){
                return camionoString + "," + fila + "," + (columna-1);
            }
            else if(bodega[fila][columna-1].equals("0")){
                System.out.println (columna);
                return camionoString + verificarEspacioVacio(fila, (columna - 1), bodega);
            }
            if(columna < bodega[0].length - 1){
                if(bodega[fila][columna+1].equals("e")){
                    return camionoString + "," + fila + "," + (columna+1);
                }
                else if(bodega[fila][columna+1].equals("0")){
                    return camionoString + verificarEspacioVacio(fila, (columna + 1), bodega);
                }
            }
        }
        if(fila != 0 && fila < bodega.length){
            if(bodega[fila-1][columna].equals("e")){
                return camionoString + "," + (fila-1) + "," + columna;
            }
            else if(bodega[fila-1][columna].equals("0")){
                return camionoString + verificarEspacioVacio((fila-1), columna, bodega);
            }
            if(fila < bodega.length - 1){
                if(bodega[fila+1][columna].equals("e")){
                    return camionoString + "," + (fila+1) + "," + columna;
                }
                else if(bodega[fila+1][columna].equals("0")){
                    return camionoString + verificarEspacioVacio((fila + 1), columna, bodega);
                }
            }
        }
        return camionoString;
    }
}