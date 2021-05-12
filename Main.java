import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Factory fac = new Factory();
        Map arbol;
        ArrayList arr = new ArrayList();
        ArrayList<String> a = new ArrayList<>(), b = new ArrayList<>();
        String linea = "";
        String str= "                      "; 
        int num = 1;
        System.out.print("Seleccione la opcion de arbol a utilizar\n1. RedBlack Tree\n2.Splay Tree\n");
        Scanner scan = new Scanner(System.in);
        int eleccion;
        try{
             eleccion=scan.nextInt();
        } catch(InputMismatchException e){
            System.out.println("No haz ingresado un numero. El programa se ejecutara con un SplayTree Tree\n");
            eleccion = 1;
        }
        arbol = fac.crearArbol(eleccion);

        
        //SE LEE EL ARCHIVO
        try {
            FileReader lector = new FileReader("Spanish.txt");
            BufferedReader buff = new BufferedReader(lector);
            while ((linea = buff.readLine()) != null){
                //Se eliminan tabulaciones y caracteres extras
                linea = linea.replaceAll(";","");
                linea = linea.replaceAll(",","");
                linea = linea.replaceAll("\t", " ");
                String [] significados = linea.split(" ");
                String ingles = significados[0];
                String espa = significados[1];
                System.out.print(ingles + " --> " + espa+"\n");
                //se guarda cada palabra en ingles con su respectivo meaning en el arbol
                arbol.put(ingles,espa);
            }
            buff.close();
            System.out.print(arbol);
        }catch (IOException ex){ 
            System.out.println("ERROR!!");
        }
        
        //SE LEE ARCHIVO A TRADUCIR
        try {
            FileReader lect = new FileReader("texto.txt");
            BufferedReader bf = new BufferedReader(lect);
            String wTrad;
            while ((linea = bf.readLine()) != null){
           
            //split de cada linea
                linea = linea.toLowerCase();
                String [] texto =linea.split(" ");
                wTrad = " ";
                for(int n=0;n<texto.length;n++){
                    String palabra = texto[n];
                    //Busca palabra en arbol
                    if(arbol.contains(palabra)){
                            wTrad+=arbol.get(palabra);
                    }
                    //sino esta la encierra en  asteriscos
                    else{
                        wTrad += ("*"+palabra+"*");
                    

                    }
                    wTrad += " ";
                }
                //se imprime oracion traducida
                System.out.print("\n"+wTrad);
            }
            bf.close();
        }catch (IOException ex){ 
            System.out.println("ERROR");
        }
    

    }
    
}
