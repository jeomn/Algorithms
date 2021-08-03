import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> trees = new HashMap<>();
		double totalTrees = 0;
		String tree;
		while((tree = br.readLine())!=null && tree.length()!=0) {
			trees.put(tree, trees.getOrDefault(tree, 0)+1);
			totalTrees++;
		}
		
		Object[] treeKey = trees.keySet().toArray();
		Arrays.sort(treeKey);
		for(Object t: treeKey) {
			double rate = (trees.get(t)/totalTrees)*100;
			String strRate = String.format("%.4f", rate);
			System.out.println(t+" "+strRate);
		}
			
	}
}
