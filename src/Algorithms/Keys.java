
public class Keys {

	public static void main(String[] args) {
		if (args.length == 2) {
			// Text mode
		} else if (args.length == 1) {
			In in = new In(args[0]);
			int R = in.readInt();
			int C = in.readInt();
			for (int r = 0; r < R; r++) {
				char dummy = in.readChar();
				for (int c = 0; c < C; c++) {
					char obs = in.readChar();
					System.out.println("r == " + r + " c == " + c + " obs == " + obs);
				}
			}
			/* Sample file for above: board.txt

			2 3
			+-+
			!@#

			*/
			
			
			// GUI mode
			while (true) {
				// read key
				// wait until there is a key!!
				while (!StdDraw.hasNextKeyTyped()) {
					// wait
				}
				char key = StdDraw.nextKeyTyped();
				if (key == 'a') {
					System.out.println("Move left");
				} else if (key == 's') {
					System.out.println("Move right");
				} else if (key == 'q') {
					System.out.println("Quit");
					break;
				} else {
					System.out.println("Illegal key!");
				}
				// "execute" key
				// check for win/loss
			}
		} else {
			System.out.println("Usage: java Keys [boardfile] [commandfile]");
		}
	}

}
