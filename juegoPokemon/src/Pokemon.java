import java.util.Random;

public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

// Añada los constructores********************
    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        nivel = 1;
        this.aguante = getAguante();
    }

    public Pokemon(String nombre, String tipo, int nivel){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.aguante = getAguante();
    }





// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int calcularPoder(Pokemon contrincante){
        Random ram = new Random();
        int poder;
        int min = nivel * 3;
        int max = nivel * 10 - 1;
        poder = ram.nextInt(max)+min;
        return poder;
        }



    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}
