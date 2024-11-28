import java.util.Random;


/**
 * clase en la que se crean todos los pokemons.
 */
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
        actualizarStats();
    }

    public Pokemon(String nombre, String tipo, int nivel){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        actualizarStats();
    }





// ******************************************


    /**
     * metodos que muestran y calculan las caracteristicas de los pokemons.
     * @return
     */
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

    public int calcularPoder(Pokemon contrincante) {
        Random ram = new Random();
        int poder;
        int min = nivel * 3;
        int max = nivel * 10 - 1;
        switch (this.nivel) {
            case 1:
                poder = ram.nextInt(max) + min;
                break;
            case 2:
                poder = ram.nextInt(max) + min;
                break;
            case 3:
                poder = ram.nextInt(max) + min;
                break;
            case 4:
                poder = ram.nextInt(max) + min;
                break;
            default:
                poder = ram.nextInt(max) + min;
                break;
        }
        if ((this.tipo.equals("agua") && contrincante.tipo.equals("fuego")) ||
                (this.tipo.equals("fuego") && contrincante.tipo.equals("tierra")) ||
                (this.tipo.equals("tierra") && contrincante.tipo.equals("agua"))) {
            poder += 2 * this.nivel;
        } else if ((this.tipo.equals("agua") && contrincante.tipo.equals("tierra")) ||
                (this.tipo.equals("fuego") && contrincante.tipo.equals("agua")) ||
                (this.tipo.equals("tierra") && contrincante.tipo.equals("fuego"))) {
            poder -= 2 * contrincante.nivel;
        }

        return Math.max(poder, 1);
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
