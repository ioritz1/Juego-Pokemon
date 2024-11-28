import java.awt.*;
import java.util.Scanner;
public class InterfazPokemon {
    private Scanner teclado;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    public void Juego() {
        System.out.println("Hola aspirante a maestro pokemon!");
        Pokemon player = menuCreacionPokemonJugador();
        for (int i = 1; i < 3; i++) {
            Pokemon rival = siguientePokemonRival(i);
            System.out.println("Presentación del pokemon oponente: " + "\n" + rival);
            player = Partida(player, rival);
            System.out.println("Pulse enter para continuar ...");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            if (player == null){
                mostrarFinPartida();
                return;
            }
        } mostrarJuegoSuperado();
    }


    /**
     * en este metodo se muestra la pelea y despues se llama al metodo que mostrara quien gana.
     * @param pokemonJugador
     * @param pokemonRival
     * @return
     */
    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival){
        Combate comb = new Combate(pokemonJugador, pokemonRival);
        while (pokemonJugador.getAguante() > 0 && pokemonRival.getAguante() > 0){
            Pokemon ganadorRonda = comb.Ronda();
            System.out.println("Gana la ronda: " + (ganadorRonda!=null? ganadorRonda.getNombre():"empate"));
            System.out.println("Aguante de " + pokemonJugador.getNombre()+": "+ pokemonJugador.getAguante());
            System.out.println("Aguante de " + pokemonRival.getNombre()+ ": " + pokemonRival.getAguante());
            System.out.println("Pulse enter para continuar ...");
            Scanner sc = new Scanner(System.in);

        }
        Pokemon ganadorComb = comb.Ganador();
        if (ganadorComb == pokemonJugador){
            pokemonJugador.subirNivel();
            System.out.println("Muy bien! has derrotado a: " + pokemonRival.getNombre());
            return pokemonJugador;
        } else {
            System.out.println("Te ha vencido: " + pokemonRival.getNombre());
            return null;
        }

    }


    private Pokemon menuCreacionPokemonJugador(){
        System.out.println("------------------------");
        System.out.println("     Crea tu Pokemon!   ");
        System.out.println("------------------------");
        System.out.print("  Introduce el nombre:  ");
        String nombre = teclado.next();
        System.out.println("Elije el tipo" + "\n1 Agua" + "\n2 tierra" + "\n3 fuego");
        int opcion = teclado.nextInt();
        String tipo = switch (opcion){
            case 1 -> tipo = "agua";
            case 2 -> tipo = "tierra";
            case 3 -> tipo = "fuego";
            default -> null;
        };
        return new Pokemon(nombre, tipo);

    }

    public Pokemon siguientePokemonRival(int numero) {
        return switch (numero){
            case 1 -> new Pokemon("Caterpie", "tierra", 1);
            case 2 -> new Pokemon("Bulbasur", "agua", 2);
            case 3 -> new Pokemon("Charmander", "fuego", 3);
            default -> null;
        };

    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }

}
