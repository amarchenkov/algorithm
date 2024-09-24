package root.pattern;

/**
 * @author Andrei Marchenkov (email: andrei.marchenkov@threatrix.io, github: amarchenkov)
 */
public class Visitor {

	public void visit(Element element) {

	}

	public static class Element {

		public void accept(Visitor visitor) {

		}

	}

}
