import java.io.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

public class missing {
	public static final long INF = Long.MAX_VALUE / 2 - 1;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = reader.readLine();

		while (line != null && !line.equals("")) {

			Vector<Vector<DoublePair>> adjList = new Vector<Vector<DoublePair>>();

			String[] data = line.split(" ");
			String[] velocities = reader.readLine().split(" ");

			for (int i = 0; i < Integer.parseInt(data[0]); i++) {
				Vector<DoublePair> neighbor = new Vector<DoublePair>();
				adjList.add(neighbor);
			}

			for (int i = 0; i < Integer.parseInt(data[1]); i++) {
				String[] edges = reader.readLine().split(" ");
				adjList.get(Integer.parseInt(edges[0]) - 1)
						.add(new DoublePair(Integer.parseInt(edges[1]) - 1, Integer.parseInt(edges[2])));
				adjList.get(Integer.parseInt(edges[1]) - 1)
						.add(new DoublePair(Integer.parseInt(edges[0]) - 1, Integer.parseInt(edges[2])));
			}

			String[] locations = reader.readLine().split(" ");
			// dijkstra
			Vector<Long> dist = new Vector<Long>();
			dist.addAll(Collections.nCopies(Integer.parseInt(data[0]), INF));
			dist.set(Integer.parseInt(locations[0]) - 1, 0L);
			PriorityQueue<DoublePair> pq = new PriorityQueue<DoublePair>(1, new Comparator<DoublePair>() {
				public int compare(DoublePair i, DoublePair j) {
					return (int) Math.signum(i.weight - j.weight);
				}
			});

			pq.offer(new DoublePair(Integer.parseInt(locations[0]) - 1,0));

			while (!pq.isEmpty()) {
				DoublePair top = pq.poll();
				long d = top.weight;
				int u = top.end;
				if (d > dist.get(u))
					continue;

				Iterator<DoublePair> it = adjList.get(u).iterator();
				while (it.hasNext()) {
					DoublePair p = it.next();
					int v = p.end;
					long weight_u_v = p.weight;
					if (dist.get(u) + weight_u_v < dist.get(v)) {
						dist.set(v, dist.get(u) + weight_u_v);
						pq.offer(new DoublePair(v, dist.get(v)));
					}
				}
			}
			DecimalFormat df = new DecimalFormat("0.00");
		//	if (dist.get(Integer.parseInt(locations[1]) - 1) == INF) {
		//		writer.write("0.00\n");
		//	} else {
				double answer = dist.get(Integer.parseInt(locations[1]) - 1)
						/ (double) (Integer.parseInt(velocities[0]) + Integer.parseInt(velocities[1]));

				//String ret = .replace(",", ".");
				writer.write(df.format(answer) + "\n");
			//}
			line = reader.readLine();
		}
		writer.close();
	}

	static class DoublePair {
		int end;
		long weight;

		public DoublePair(int end, long weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}
