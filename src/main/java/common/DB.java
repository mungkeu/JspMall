package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

//    public static Connection getConnection(){
//        Connection conn = null;
//        try{
//            Context initContext = new InitialContext();
//            Context envContext = (Context) initContext.lookup("java:/comp/env");
//            DataSource ds = (DataSource) envContext.lookup("jdbc/oraDB");
//            conn = ds.getConnection();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return conn;
//    }
    public static Connection dbConn(){
        DataSource ds = null;
        Connection conn = null;
        try{
            Context ctx = new InitialContext(); // Context 객체로 Context.xml을 읽어들인다.
            ds=(DataSource) ctx.lookup("java:comp/env/oraDB"); // 이름이 일치하는지 확인
            conn=ds.getConnection(); // 일치하면 커넥션을 하나 얻어온다.
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs){
        try{
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void close(Connection conn, PreparedStatement stmt){
        try{
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
