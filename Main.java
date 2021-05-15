import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Factory fac = new Factory();
        Map arbol;
        ArrayList arr = new ArrayList();
        ArrayList<String> a = new ArrayList<>(), b = new ArrayList<>();
        String linea = "";
        String str= "                      "; 
        int num = 1;
        System.out.println("Seleccione la opcion de arbol a utilizar");
        System.out.println("1. RedBlack Tree");
        System.out.println("2. SplayTree");
        Scanner scan = new Scanner(System.in);
        int eleccion;
        try{
             eleccion=scan.nextInt();
        } catch(InputMismatchException e){
            System.out.println("No haz ingresado un numero. El programa se ejecutara con un SplayTree Tree\n");
            eleccion = 1;
        }
        arbol = fac.crearArbol(eleccion);


        /*Se lee el Archivo Spanish.txt*/
        //SE LEE EL ARCHIVO
        try{
            File file = new File("Spanish.txt");

            if(!file.exists()) {
                file.createNewFile();
            }

            FileReader reader = new FileReader(file);
            BufferedReader breader = new BufferedReader(reader);
            String linea2 = "";

            while((linea = breader.readLine()) != null) {

                if(linea.charAt(0) == '#'){
                    continue;
                } else{

                    final String[] temp = linea.split("\\s+");

                    if(temp.length > 2)
                    {
                        linea2 = temp[1] + " " + temp[2];
                    }else if(temp.length == 2)
                    {
                        linea2 = temp[1];
                    }else if(temp.length < 1)
                    {
                        linea2 = " ";
                        temp[1] = linea2;
                    }
                    if(temp.length > 1){
                        arbol.put(temp[0], temp[1]);
                    }


                }

            }


            breader.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    /*Se lee el Archivo txt */
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