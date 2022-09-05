import java.sql.*;

public class TermProjectStatisticsMadsix {

    // 설문자별 통계 쿼리 받기
    public String getSurveyeeQuery() {
        String query = "SELECT surveyee.ID, surveyee.Name, a1.answer as question1, a2.answer as question2, a3.answer as question3, a4.answer as question4 " +
        "FROM (((((questions " +
        "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
        "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
        "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
        "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
        "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4)";
        return query;
    }
    
    // 설문자별 통계
    public void pollsSurveyee (ResultSet rs) {

        try {
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID : " + rs.getInt("surveyee.ID"));
                System.out.println(" NAME : " + rs.getString("surveyee.Name"));
                System.out.println(", 백화점의 입지는 접근하기에 용이한가? : " + rs.getString("question1"));
                System.out.println(", 백화점의 고객응대는 만족스러운가? : " + rs.getString("question2"));
                System.out.println(", 백화점의 편의시설은 잘 마련되어 있는가? : " + rs.getString("question3"));
                System.out.println(", 백화점 내 입점 매장은 다양한가? : " + rs.getString("question4"));
                System.out.println();
             }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
    // 문항별 통계 쿼리 받기
    public String getQuestion1Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "LEFT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question1 " +
                        "GROUP BY Q1.question1 " +
                        "ORDER BY answers.Answer_key";
        return query;
    }
    public String getQuestion2Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "LEFT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question2 " +
                        "GROUP BY Q1.question2 " +
                        "ORDER BY answers.Answer_key";
        return query;
    }
    public String getQuestion3Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "LEFT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question3 " +
                        "GROUP BY Q1.question3 " +
                        "ORDER BY answers.Answer_key";
        return query;
    }
    public String getQuestion4Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "LEFT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question4 " +
                        "GROUP BY Q1.question4 " +
                        "ORDER BY answers.Answer_key";
        return query;
    }
   
    // 문항별 통계
    public void pollsQuestion (ResultSet rs) {

        try {
            while (rs.next()) {
                // Retrieve by column name
                System.out.print(rs.getString("answer") + " : ");
                System.out.println(rs.getInt("COUNT(ID)") + "개");
             }
             System.out.println();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
