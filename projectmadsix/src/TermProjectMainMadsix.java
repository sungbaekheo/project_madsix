import java.sql.*;

public class TermProjectMainMadsix {

    static final String DB_URL = "jdbc:mysql://localhost/miniproject_madsix";
    static final String USER = "root";
    static final String PASS = "tbrs00002b";

    public static void main(String[] args) {
        
        TermProjectStatisticsMadsix stats = new TermProjectStatisticsMadsix();
      
        
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            )
        {
            // 설문자별 통계 출력
            ResultSet rs = stmt.executeQuery(stats.getSurveyeeQuery());
			stats.pollsSurveyee(rs);

            // 문항별 통계 출력
            //rs = stmt.executeQuery(stats.getQuestion1Query()); // 1번 문항
            //rs = stmt.executeQuery(stats.getQuestion2Query()); // 1번 문항
            rs = stmt.executeQuery(stats.getQuestion3Query()); // 1번 문항
            //rs = stmt.executeQuery(stats.getQuestion4Query()); // 1번 문항
            stats.pollsQuestion(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
   }
}
    
