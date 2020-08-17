package xocayev.dboperations;

import xocayev.dbconfig.MySQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class DepartmentsDAO {

    public  String addNewDept(String deptname,int  deptid,int managerid, int locationid){
        MySQLConfig mySQLConfig=new MySQLConfig();
        String sql="insert into departments values(?,?,?,?)";
        String status;
        try(Connection conn=mySQLConfig.getConnect()) {

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,deptid);
            ps.setString(2,deptname);
            ps.setInt(3,managerid);
            ps.setInt(4,locationid);


            int  result=ps.executeUpdate();
            status=result>0?"SUCCESS":"FAILD";

            ps.close();

        }catch (Exception e){
            e.printStackTrace();
            status=e.getMessage();
        }finally {
            mySQLConfig.close();
        }
        return status;
    }


    public  String deleteept( int  deptid){
        MySQLConfig mySQLConfig=new MySQLConfig();
        String sql="delete from  departments where department_id=? ";
        String status;
        try(Connection conn=mySQLConfig.getConnect()) {

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,deptid);



            int  result=ps.executeUpdate();
            status=result>0?"SUCCESS":"FAILD";

            ps.close();

        }catch (Exception e){
            e.printStackTrace();
            status=e.getMessage();
        }finally {
            mySQLConfig.close();
        }
        return status;
    }

}
