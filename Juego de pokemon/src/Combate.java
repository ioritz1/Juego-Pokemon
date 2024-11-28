/**
 * Esta clase es la que se encarga de crear dos pokemons y hacerlos pelear, despues mostrara un ganador
 */

public class Combate {

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
