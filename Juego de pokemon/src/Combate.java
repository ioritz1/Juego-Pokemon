/**
 * Esta clase es la que se encarga de crear dos pokemons y hacerlos pelear, despues mostrara un ganador
 */

public class Combate {

    /**
     * @param pokemonJugador es el pokemon que creara el jugador
     * @param pokemonRival es un pokemon que se creara automaticamente en vase al nivel de tu pokemon
     */
    // Añada los atributos y el constructor *************
    private Pokemon pokemonJugador;
    private Pokemon pokemonRival;


    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }



    //***************************************************


    public Pokemon Ronda(){
        int poderJugador = pokemonJugador.calcularPoder(pokemonJugador);
        int poderRival = pokemonRival.calcularPoder(pokemonRival);

        if (poderJugador > poderRival){
            pokemonRival.disminuirAguante();
            return pokemonJugador;
        } else if (poderRival > poderJugador){
            pokemonJugador.disminuirAguante();
            return pokemonRival;
        } else {
            return null;
        }
    }

    /**
     *
     * @return devolvera el ganador del juego
     */
    public Pokemon Ganador(){
        if (pokemonJugador.getAguante()<= 0){
            return pokemonRival;
        } else if (pokemonRival.getAguante()<=0){
            return pokemonJugador;
        } else {
            return null;
        }
    }


}
