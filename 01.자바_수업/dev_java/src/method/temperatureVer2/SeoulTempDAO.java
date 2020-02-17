package method.temperatureVer2;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr;

import method.temparature.SeoulTempVO;

public class SeoulTempDAO {
    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public String[] getYear() {
        String years[] = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT distinct(ta_year) ta_year");
        sb.append("  FROM (SELECT TO_CHAR(TO_DATE(sdate),'YYYY') ta_year FROM seoultemp");
        sb.append(" WHERE TO_CHAR(TO_DATE(sdate),'YYYY') > TO_CHAR(sysdate,'YYYY')-11)");
        sb.append(" ORDER BY ta_year desc");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();
            Vector<String> v= new Vector<>();
            while(rs.next()) {
                String ta_year = rs.getString("ta_year");
                v.add(ta_year);
            }
            years = new String[v.size()];
            v.copyInto(years);
            System.out.println("size : "+v.size());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return years;
    }
    public String[] getMonth(String year) {
        String months[] = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT distinct(to_char(to_date(sdate),'MM')) ta_mm");
        sb.append("  FROM seoultemp");
        sb.append(" WHERE TO_CHAR(TO_DATE(sdate),'YYYY')=?");
        sb.append(" ORDER BY to_char(to_date(sdate),'MM') asc");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, year);
            rs = pstmt.executeQuery();
            Vector<String> v= new Vector<>();
            while(rs.next()) {
                String ta_mm = rs.getString("ta_mm");
                v.add(ta_mm);
            }
            months = new String[v.size()];
            v.copyInto(months);
            System.out.println("size : "+v.size());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return months;
    }   
    public List<Map<String,Object>> getTempList(SeoulTempVO stVO){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sdate, matemp, mitemp, atemp FROM seoultemp");
        if(stVO.getSdate()!=null) {
                sb.append(" WHERE sdate =?");
        }
        else {
            sb.append(" WHERE sdate LIKE ?");	//2019/05||'%'
                
        }
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sb.toString());
            String imsi = "";
            if(stVO.getSdate()!=null) {           
                pstmt.setString(1, stVO.getSdate());
            }else {
                imsi = stVO.getnYear()+"/"+stVO.getnMonth()+"%";
                pstmt.setString(1, imsi);
            }
            System.out.println("? ==>"+imsi);
            rs = pstmt.executeQuery();
            Map<String,Object> rMap = null;
            while(rs.next()) {
                rMap = new HashMap<>();
                rMap.put("matemp",rs.getDouble("matemp"));
                rMap.put("mitemp",rs.getDouble("mitemp"));
                rMap.put("sdate",rs.getString("sdate"));
                list.add(rMap);
            }
            System.out.println("[[query]]"+sb.toString());
            System.out.println("size : "+list.size());
        }catch(SQLException se) {
            System.out.println("[[query]]"+sb.toString());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
