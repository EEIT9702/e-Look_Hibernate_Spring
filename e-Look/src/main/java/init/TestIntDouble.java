package init;

import java.util.*;

public class TestIntDouble {

	public static void main(String[] args) {
		List<String> list1 = new LinkedList<String>();
		list1.add("java");
		list1.add("java");
		list1.add("java");
		list1.add("SQL");
		list1.add("SQL");
		list1.add("js");
		HashMap<String, Integer> map = new HashMap<String,Integer>();		
		for(String keyword:list1){
			if(map.containsKey(keyword)){
				System.out.println("111");
				Integer count=map.get(keyword);
				count++;
				map.replace(keyword, count);
			}else{
				map.put(keyword, 1);
			}
		}
		
		System.out.println(map.size());
		
		
		
		
	}

}
