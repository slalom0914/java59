package book.chap12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListNMapTest {
	public List<Map<String,Object>> getDeptList() {
		List<Map<String,Object>> deptList = new ArrayList<>();
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("deptno",10);
		pMap.put("dname","ACCOUNTING");
		pMap.put("loc","NEW YORK");
		deptList.add(pMap);
		pMap = new HashMap<>();
		pMap.put("deptno",20);
		pMap.put("dname","RESEARCH");
		pMap.put("loc","DALLAS");
		deptList.add(pMap);
		pMap = new HashMap<>();
		pMap.put("deptno",30);
		pMap.put("dname","SALES");
		pMap.put("loc","CHICAGO");
		deptList.add(pMap);
		return deptList;
	}
	public static void main(String[] args) {
		ListNMapTest lmt = new ListNMapTest();
		List<Map<String,Object>> deptList = lmt.getDeptList();
		for(int i=0;i<deptList.size();i++) {
			Map<String,Object> pMap = deptList.get(i);
			Object keys[] = pMap.keySet().toArray();
			for(int j=0;j<keys.length;j++) {
				System.out.print(pMap.get(keys[j])+" ");
			}
			System.out.println();//개행처리-줄바꿈처리
		}
	}
}









