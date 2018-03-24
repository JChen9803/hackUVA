import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class questions {
	
	ArrayList<ArrayList<Map>> levels;
	
	ArrayList<Map> easy;
	ArrayList<Map> medium;
	ArrayList<Map> difficult;

	Map<String, Integer> e1;
	Map<String, Integer> e2;
	Map<String, Integer> e3;
	Map<String, Integer> e4;
	Map<String, Integer> e5;
	
	Map<String, Integer> m1;
	Map<String, Integer> m2;
	Map<String, Integer> m3;
	Map<String, Integer> m4;
	Map<String, Integer> m5;
	
	Map<String, Integer> d1;
	Map<String, Integer> d2;
	Map<String, Integer> d3;
	Map<String, Integer> d4;
	Map<String, Integer> d5;

	
	public static void main(String[] args) {
		new questions();
	}
	
	public questions() {
		
		levels = new ArrayList<ArrayList<Map>>();
		
		easy = new ArrayList<Map>();
		medium = new ArrayList<Map>();
		difficult = new ArrayList<Map>();
		
		e1 = new HashMap<String,Integer>();
		e2 = new HashMap<String,Integer>();
		e3 = new HashMap<String,Integer>();
		e4 = new HashMap<String,Integer>();
		e5 = new HashMap<String,Integer>();
		
		m1 = new HashMap<String,Integer>();
		m2 = new HashMap<String,Integer>();
		m3 = new HashMap<String,Integer>();
		m4 = new HashMap<String,Integer>();
		m5 = new HashMap<String,Integer>();
		
		d1 = new HashMap<String,Integer>();
		d2 = new HashMap<String,Integer>();
		d3 = new HashMap<String,Integer>();
		d4 = new HashMap<String,Integer>();
		d5 = new HashMap<String,Integer>();
		
		e1.put("5 x 3 =", 15);
		e2.put("7 + 3 + 10 =", 20);
		e3.put("17 - 7 =", 10);
		e4.put("4 / 2 =", 2);
		e5.put("10 - 2 =", 8);
		
		m1.put("8 + 6 + 9 =", 23);
		m2.put("9 x 12 =", 108);
		m3.put("63 - 56 =", 7);
		m4.put("56 / 8 =", 7);
		m5.put("17 + 26 =", 43);
		
		d1.put("23 + 74 + \n13 =", 110);
		d2.put("16 x 3 x 3 =", 144);
		d3.put("(132 / 11) / 2 =", 6);
		d4.put("232 - 74 - 55 + 4 =", 107);
		d5.put("(12 x 6) + (8 x 4)  =", 104);
		
		easy.add(e1);
		easy.add(e2);
		easy.add(e3);
		easy.add(e4);
		easy.add(e5);
		
		medium.add(m1);
		medium.add(m2);
		medium.add(m3);
		medium.add(m4);
		medium.add(m5);
		
		difficult.add(d1);
		difficult.add(d2);
		difficult.add(d3);
		difficult.add(d4);
		difficult.add(d5);

		levels.add(easy);
		levels.add(medium);
		levels.add(difficult);

		System.out.println(levels);
		
		
		
	}

}
