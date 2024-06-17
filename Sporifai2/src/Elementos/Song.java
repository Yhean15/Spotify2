package Elementos;

public class Song {
    public int[] ID;
    public String nombre;
    public String artista;
    public double duracion; //milisegundos 100 ms = 1s

    public Song(String nombre, String artista, double duracion){
        this.nombre=nombre;
        this.artista=artista;
        this.duracion=duracion;

        ID = new int[nombre.length()];

        for(int i=0; i<ID.length; i++){
            ID[i] = nombre.charAt(i);
        }
    }
}
