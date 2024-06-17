package DS;
import Node.RSong;
import Node.NSong;
import Elementos.Song;


public class BST {
    public RSong root;

    public BST(){}

    public boolean isHigher(int[] NR, int[] NH){
        int size = Math.min(NR.length, NH.length);

        for(int i=0; i<size; i++){
            if(NR[i] > NH[i]){
                return true;
            }
        }
        return Math.max(NR.length, NH.length) > NH.length;
    }

    public void Insert(NSong NH){
        RSong temp = root;
        while(temp != null) {
            if (isHigher(temp.Key.ID, NH.Key.ID)) {
                if (temp.left == null) {
                    temp.left = new RSong(NH.Key);
                    return;
                }
                temp = temp.left;
            }
            else{
                if(temp.rigth == null){
                    temp.rigth = new RSong(NH.Key);
                    return;
                }
                temp = temp.rigth;
            }
        }
    }

    public void Agregar(LinkedList DB){

        NSong Ntemp = DB.head;

        if(root == null){
            root = new RSong(Ntemp.Key);
            Ntemp = Ntemp.Next;

        }


        while(Ntemp != null){

            Insert(Ntemp);
            Ntemp = Ntemp.Next;

        }

    }

    public boolean ComparateN(int[] IDR, int[] IDS){
        if(IDR.length != IDS.length){
            return false;
        }
        int cont = 0;
        for(int i=0; i<IDS.length; i++){
            if(IDR[i] == IDS[i]){
                cont++;
            }
        }
        return cont == IDS.length;
    }

    public Song BuscarNombre(String nombre){
        int[] IDN = new int[nombre.length()];

        for(int i=0; i<IDN.length; i++){
            IDN[i] = nombre.charAt(i);
        }

        RSong temp = root;
        Song Stemp;

        while(temp != null){
            Stemp = temp.Key;
            if(ComparateN(Stemp.ID, IDN)){
                return Stemp;
            }
            if(isHigher(Stemp.ID, IDN)){
                temp = temp.left;
            }
            else{
                temp = temp.rigth;
            }
        }
        return null;
    }


    public void BuscarDuration(double duration, RSong temp){
        int cont = 0;
        if(temp == null){
            return;
        }
        BuscarDuration(duration, temp.left);
        if(duration == temp.Key.duracion){
            System.out.println("Nombre: " + temp.Key.nombre);
            System.out.println("Artista: " + temp.Key.artista);
            System.out.println("Duracion: " + temp.Key.duracion);
            System.out.print("ID: ");
            for(int i = 0; i< temp.Key.ID.length; i++){
                System.out.print(temp.Key.ID[i] + " ");
            }
            System.out.println();
            cont++;
        }
        BuscarDuration(duration, temp.rigth);
        if(cont == 0){
            System.out.println("No existen canciones con esta duracion");
        }
    }

    public void InOrderN(RSong temp){
        int cont = 0;
        if(temp == null){
            return;
        }
        InOrderN(temp.left);
        System.out.println("Nombre: " + temp.Key.nombre);
        System.out.println("Artista: " + temp.Key.artista);
        System.out.println("Duracion: " + temp.Key.duracion);
        System.out.print("ID: ");
        for(int i = 0; i< temp.Key.ID.length; i++){
            System.out.print(temp.Key.ID[i] + " ");
        }
        cont++;
        System.out.println();
        InOrderN(temp.rigth);
        if(cont == 0){
            System.out.println("No existe ninguna cancion");
        }
    }

    public void inOrderToList(RSong node, LinkedList list) {
        if (node == null) {
            return;
        }
        inOrderToList(node.left, list);
        list.Insert(node.Key);
        inOrderToList(node.rigth, list);
    }

    public LinkedList sortByDuration() {
        LinkedList list = new LinkedList();
        inOrderToList(root, list);
        list.head = list.mergeSort(list.head);
        return list;
    }

}
