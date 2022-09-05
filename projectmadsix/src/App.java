import java.util.Scanner;

public class App {
    public static boolean poll = true;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in); 
        TermProjectStatisticsMadsix stats = new TermProjectStatisticsMadsix();
        TermProjectPollsMadsix polls = new TermProjectPollsMadsix();

        while(poll) {
            System.out.println("메뉴를 선택해주세요.");
            System.out.println("설문: P     통계: S     종료: Q");
            System.out.print("선택 : ");
            String choice = scan.nextLine();

            switch (choice) {
                case "p" :
                case "P" :
                    System.out.println("설문을 시작합니다.");
                    break;
                case "s" :
                case "S" :
                    boolean sts = true;
                    while (sts) {
                        stats.startStatistics();
                        int menu = Integer.parseInt(scan.nextLine());
                            switch (menu) {
                                case 1 :
                                    ResultSet rs = stmt.executeQuery(stats.getSurveyeeQuery());
                                    stats.pollsSurveyee(rs);
                                    break;
                                case 2 :
                                    stats.questionList();
                                    int opt = Integer.parseInt(scan.nextLine());
                                    switch (opt) {
                                        case 1 : rs = stmt.executeQuery(stats.getQuestion1Query()); // 1번 문항
                                                stats.pollsQuestion(rs);
                                                break;
                                        case 2 : rs = stmt.executeQuery(stats.getQuestion2Query()); // 2번 문항
                                                stats.pollsQuestion(rs);
                                                break;
                                        case 3 : rs = stmt.executeQuery(stats.getQuestion3Query()); // 3번 문항
                                                stats.pollsQuestion(rs);
                                                break;
                                        case 4 : rs = stmt.executeQuery(stats.getQuestion4Query()); // 4번 문항
                                                stats.pollsQuestion(rs);
                                                break;
                                        case 5 :
                                            System.out.println("이전 메뉴로 돌아갑니다.\n");
                                            break;
                                    }
                                    break;
                                case 3 :

                                    break;
                                case 4 :
                                    System.out.println("이전 메뉴로 돌아갑니다.\n");
                                    sts = false;
                            }
                    }
                    break;
                case "q" :
                case "Q" :
                    System.out.println("설문을 종료합니다.");
                    poll = false;

            }
            System.out.println();
        }
         

        
    }
}
