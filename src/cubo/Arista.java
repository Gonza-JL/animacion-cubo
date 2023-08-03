package cubo;

public class Arista implements Comparable<Arista> {

	private int vertice1;
	private int vertice2;

	public Arista(int vertice1, int vertice2) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}

	public int getV1() {
		return vertice1;
	}

	public int getV2() {
		return vertice2;
	}

	@Override
	public int compareTo(Arista objArista) {
		if (vertice1 == objArista.vertice1 && vertice2 == objArista.vertice2 || 
				vertice1 == objArista.vertice2 && vertice2 == objArista.vertice1) {
			return 0;
		}
		return -1;
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("arista ");
		st.append(vertice1);
		st.append(" - ");
		st.append(vertice2);
		return st.toString();
	}
}
