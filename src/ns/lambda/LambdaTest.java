/**
 * 
 */
package ns.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ns.lambda.interfaces.Game;
import ns.lambda.interfaces.GameTwo;

/**
 * @author
 *
 */
public class LambdaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// old java create anonymous class implements the intarface.
		Game football = new Game() {
			@Override
			public void play() {
				System.out.println("Football");
			}
		};
		System.out.println("Game football = new Game() { ... };");
		football.play();
		System.out.println("\n");

		// above implementation in Lambda all below is correct.
		Game footballLambda = () -> {
			System.out.println("Football Lambda");
		};
		System.out.println("Game footballLambda = () -> { ... };");
		footballLambda.play();
		System.out.println("\n");

		Game footballLambda2 = () -> System.out.println("Football Lambda 2");
		System.out.println("Game footballLambda2 = () -> ... ;");
		footballLambda2.play();
		System.out.println("\n");

		/** Lambda with method parameters **/
		GameTwo footballParaMethod = new GameTwo() {
			@Override
			public void play(String type) {
				System.out.println("Football type " + type);
			}
		};
		System.out.println("GameTwo footballParaMethod = new GameTwo() { ... };");
		footballParaMethod.play("Outdoor");
		System.out.println("\n");

		// in lambda
		GameTwo footballParaMethodLambda = (String type) -> {
			System.out.println("Football type " + type);
		};
		System.out.println("GameTwo footballParaMethodLambda = (String type) -> { ... };");
		footballParaMethodLambda.play("Outdoor");
		System.out.println("\n");

		GameTwo footballParaMethodLambda2 = (type) -> {
			System.out.println("Football type " + type);
		};
		System.out.println("GameTwo footballParaMethodLambda2 = (type) -> { ... };");
		footballParaMethodLambda2.play("Outdoor");
		System.out.println("\n");

		GameTwo footballParaMethodLambda3 = (type) -> System.out.println("Football type " + type);
		System.out.println("GameTwo footballParaMethodLambda3 = (type) -> ... ;");
		footballParaMethodLambda3.play("Outdoor");
		System.out.println("\n");

		GameTwo footballParaMethodLambda4 = type -> System.out.println("Football type " + type);
		System.out.println("GameTwo footballParaMethodLambda4 = type -> ... ;");
		footballParaMethodLambda4.play("Outdoor");
		System.out.println("\n");

		/** Lambda in foreach and steams **/
		List<String> players = Arrays.asList("Sanath", "Aravinda", "Arjuna", "Roshan", "Kaluwitharana", "Mavan", "Vaas");

		// Streams
		players //
				.stream() // stream to all
				.forEach((player) -> {
					System.out.println("List .forEach() :- " + player);
				});
		// .forEach((player) -> System.out.println(player));
		// .forEach(player -> System.out.println(player));
		System.out.println("\n");

		players //
				.stream() // stream to all
				.filter(player -> player.equals("Sanath")) // filtering. this is like if(player.equals("playername"))
				.forEach((player) -> {
					System.out.println("List .forEach() with filter :- " + player);
				});
		System.out.println("\n");

		// Get the value out from stream.
		Optional<String> optional = players.stream() //
				.filter(player -> player.equals("Arjuna")) // filter to player equals to Arjuna
				.findFirst(); // Get that value as output.

		System.out.println("Captain Arjuna is " + (optional.isPresent() ? "in" : "not in") + " the team.");
	}

}
