package Node;
import Elementos.Song;
public class RSong {
    public Song Key;
    public RSong left;
    public RSong rigth;

    public RSong(Song K){
        this.Key=K;
    }
}
