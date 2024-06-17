import DS.LinkedList;
import DS.BST;
import Elementos.Song;

import java.util.Objects;
import java.util.Scanner;
public class APP {
    public static void main(String[] args){
        LinkedList DataBase = null;
        BST TreeDataBase = new BST();
        String nombre;
        String artista;
        double duration;
        String repeat = null;
        int op;
        Scanner KeyBoard = new Scanner(System.in);
        Song cancion;
///////////////////////////////////////////////////////////////////////

    do{
        System.out.println("1. Ingresar canciones");
        System.out.println("2. Buscar cancion por nombre");
        System.out.println("3. Buscar cancion por duracion");
        System.out.println("4. Ordenar por nombre");
        System.out.println("5. Ordenar por duracion");
        System.out.println("Ingrese La opcion que desea realizar");
        op = KeyBoard.nextInt();

        switch (op){
            case 1:
                int size = 0;
                DataBase = new LinkedList();
                System.out.print("Ingrese cuantas canciones desea agregar: ");
                size = KeyBoard.nextInt();
                for(int i=0; i<size; i++) {
                    System.out.print("Ingrese el nombre: ");
                    nombre = KeyBoard.next();
                    System.out.print("Ingrese al artista: ");
                    artista = KeyBoard.next();
                    System.out.print("Ingrese la duracion: ");
                    duration = KeyBoard.nextDouble();
                    cancion = new Song(nombre, nombre, duration);
                    DataBase.Insert(cancion);
                }
                
                TreeDataBase.Agregar(DataBase);
                
                break;
                
            case 2:
                System.out.println("Ingrese el nombre de la cancion que va a buscar");
                nombre = KeyBoard.next();

                if(TreeDataBase.BuscarNombre(nombre) != null){
                    Song temp = TreeDataBase.BuscarNombre(nombre);
                    System.out.println("Nombre: " + temp.nombre);
                    System.out.println("Artista: " + temp.artista);
                    System.out.println("Duracion: " + temp.duracion);
                    System.out.print("ID: ");
                    for(int i = 0; i< temp.ID.length; i++){
                        System.out.print(temp.ID[i] + " ");
                    }
                    System.out.println();
                }
                break;
                
            case 3:
                System.out.println("ingrese la duracion que desea buscar: ");
                duration = KeyBoard.nextDouble();

                TreeDataBase.BuscarDuration(duration, TreeDataBase.root);
                break;
                
            case 4:
                System.out.println("orden por nombre");
                TreeDataBase.InOrderN(TreeDataBase.root);
                break;
                
            case 5:
                LinkedList SortedDuration = TreeDataBase.sortByDuration();
                System.out.println("orden por duracion");
                SortedDuration.Print();
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }

        System.out.println("Deseas repetir algun proceso?");
        repeat = KeyBoard.next();
    }while(!Objects.equals(repeat, "no"));
    }
}
