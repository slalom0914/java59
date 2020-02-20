package book.chap12;

import java.util.Vector;

import com.google.gson.Gson;

import method.zipcode.ZipCodeSearchApp;
import oracle.jdbc2.ZipCodeVO;

public class ZipCodeTest {
	public void gsonFormat(Vector<ZipCodeVO> v) {
		Gson g = new Gson();
		String temp = g.toJson(v);
		System.out.println(temp);
	}
	public static void main(String[] args) {
		//
		ZipCodeTest zcTest = new ZipCodeTest();
		ZipCodeSearchApp zcApp = new ZipCodeSearchApp();
		Vector<ZipCodeVO> v = zcApp.refreshData(null, "가산동");
		zcTest.gsonFormat(v);
		System.out.println(v.size());
		for(int i=0;i<v.size();i++) {
			ZipCodeVO zcVO=v.get(i);
			System.out.println(zcVO.getAddress());
			//System.out.println(zcVO.address);
		}
	}

}
