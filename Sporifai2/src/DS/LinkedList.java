package DS;
import Elementos.Song;
import Node.NSong;

public class LinkedList {
    public NSong head;

    public LinkedList(){}

    public void Insert(Song newSong){
        NSong temp;
        if(head == null){
            temp = new NSong(newSong);
            head = temp;
            return;
        }

        temp = head;
        while(temp.Next != null){
            temp = temp.Next;
        }

        temp.Next = new NSong(newSong);
    }

    public NSong mergeSort(NSong node) {
        if (node == null || node.Next == null) {
            return node;
        }

        NSong middle = getMiddle(node);
        NSong nextOfMiddle = middle.Next;
        middle.Next = null;

        NSong left = mergeSort(node);
        NSong right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    public NSong getMiddle(NSong head) {
        if (head == null) {
            return head;
        }

        NSong slow = head;
        NSong fast = head.Next;

        while (fast != null && fast.Next != null) {
            slow = slow.Next;
            fast = fast.Next.Next;
        }
        return slow;
    }

    public NSong merge(NSong left, NSong right) {
        NSong result;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.Key.duracion <= right.Key.duracion) {
            result = left;
            result.Next = merge(left.Next, right);
        } else {
            result = right;
            result.Next = merge(left, right.Next);
        }
        return result;
    }

    public void Print(){
        NSong temp = head;
        while(temp != null){
            System.out.println("Nombre: " + temp.Key.nombre);
            System.out.println("Artista: " + temp.Key.artista);
            System.out.println("Duracion: " + temp.Key.duracion);
            System.out.print("ID: ");
            for(int i = 0; i< temp.Key.ID.length; i++){
                System.out.print(temp.Key.ID[i] + " ");
            }
            System.out.println();
            temp = temp.Next;
        }
    }



}
