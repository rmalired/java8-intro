/**
 * 
 */
package indiv.rakesh.java8.intro;

/**
 * @author rakesh.malireddy
 *
 */
@FunctionalInterface
public interface IPerson<T,U,S,R> {

	R apply(T t, U u, S s);
}
