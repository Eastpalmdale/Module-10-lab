import java.util.*;

public class FREE_QUID {
    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("Jolly Fellows");
        myList.add("Centaurs");
        myList.add("SHADOW WIZARD MONEY GANG");
        myList.add("Leprechauns");
        myList.add("Gladiators");
        myList.add("Emo kids");
        myList.add("Nyarlathotep");
        myList.add("Orcs");
        int quarterCount;
        boolean snitchWin;

        Collections.shuffle(myList);

        System.out.println("Let's start the playoffs!");
        for (int i = 0; i < myList.size(); i++){

            System.out.println(i+1+". ");
            System.out.println(myList.get(i));

        }

        // first round
        safeinput.prettyHeader("Round one!");
        System.out.println();
        // 1 plays 8
        System.out.println("Match 1");
        quarterCount = 0;
        for (int i = 1; i <= 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin = PlayGame(quarterCount,6, 7,myList);
            if (snitchWin){
                break;
            }
        }
        // 2 plays 7
        System.out.println("Match 2");
        quarterCount = 0;
        for (int i = 1; i <= 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin = PlayGame(quarterCount,4, 5,myList);
            if (snitchWin){
                break;
            }
        }
        // 3 plays 6
        System.out.println("Match 3");
        quarterCount = 0;
        for (int i = 1; i < 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin =PlayGame(quarterCount,2, 3,myList);
            if (snitchWin){
                break;
            }
        }
        // 4 plays 5
        System.out.println("Match 4");
        quarterCount = 0;
        for (int i = 1; i <= 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin=PlayGame(quarterCount,0, 1,myList);
            if (snitchWin){
                break;
            }
        }

        // second round
        System.out.println("Round two!");
        System.out.println();
        // 1 plays 4
        System.out.println("Match 1");
        quarterCount = 0;
        for (int i = 1; i <= 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin=PlayGame(quarterCount,2, 3,myList);
            if (snitchWin){
                break;
            }
        }
        // 2 plays 3
        System.out.println("Match 2");
        quarterCount = 0;
        for (int i = 1; i <= 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin=PlayGame(quarterCount,0, 1,myList);
            if (snitchWin){
                break;
            }
        }

        // third round
        System.out.println("Round three!");
        System.out.println();
        // 1 plays 2
        System.out.println("Final Match");
        quarterCount = 0;
        for (int i = 1; i <= 4; i++){
            quarterCount++;
            System.out.println("Quarter "+i);
            snitchWin=PlayGame(quarterCount,0, 1,myList);
            if (snitchWin){
                break;
            }
        }

        System.out.println("The "+myList.get(0)+" are the winners!");

    }
    public static boolean PlayGame(int quarterCount, int teamA, int teamB, ArrayList<String> teams) {

        System.out.println(teams.get(teamA)+" vs "+teams.get(teamB));
        Random rnd = new Random();

        int teamAScore = rnd.nextInt(4)*10;
        int teamBScore = rnd.nextInt(4)*10;
        int goldenSnitch= rnd.nextInt(20);
        int totalTeamAScore = 0;
        int totalTeamBScore = 0;
        boolean goldenSnitchWin = false;
        if (goldenSnitch == 0 || goldenSnitch == 10 || goldenSnitch == 20){
            int teamAssignment = rnd.nextInt(1);
            if (teamAssignment == 1){
                teamAScore = 9001;
                System.out.println(teams.get(teamA)+" Won due to the golden snitch!");
                goldenSnitchWin = true;
            }
            else if (teamAssignment == 0){
                teamBScore = 9001;
                System.out.println(teams.get(teamB)+" Won due to the golden snitch!");
                goldenSnitchWin = true;
            }
        }
        System.out.print("Team A scored "+teamAScore+" ");
        System.out.println("Team B scored "+teamBScore);
        totalTeamAScore = totalTeamAScore+teamAScore;
        totalTeamBScore = totalTeamBScore+teamBScore;
        if (quarterCount==4 && teamAScore > teamBScore || goldenSnitchWin) {
            System.out.println("The "+teams.get(teamA)+" defeated "+teams.get(teamB));
            System.out.println("Final score "+totalTeamBScore+" - "+totalTeamAScore);
            System.out.println();
            System.out.println(teams.get(teamB)+" Are eliminated!");
            teams.remove(teamB);
        }
        else if (quarterCount==4 && teamBScore > teamAScore || goldenSnitchWin) {
            System.out.println("The "+teams.get(teamB)+" defeated "+teams.get(teamA));
            System.out.println("Final score "+totalTeamBScore+" - "+totalTeamAScore);
            System.out.println();
            System.out.println(teams.get(teamA)+" Are eliminated!");
            teams.remove(teamA);
        }
        if (quarterCount == 4 && teamAScore == teamBScore){
            System.out.println("Going into overtime! The score is tied "+teamAScore+" - "+teamBScore);
            boolean victory;
            do{
                int OTScoreA = rnd.nextInt(2)*10;
                int OTScoreB = rnd.nextInt(2)*10;

                teamAScore = teamAScore + OTScoreA;
                teamBScore = teamBScore + OTScoreB;

                if (teamAScore > teamBScore){

                    System.out.println("The "+teams.get(teamA)+" defeated "+teams.get(teamB));
                    System.out.println("Final score "+totalTeamBScore+" - "+totalTeamAScore);
                    System.out.println();
                    System.out.println(teams.get(teamB)+" Are eliminated!");
                    teams.remove(teamB);
                    victory = true;
                }
                else if (teamBScore > teamAScore) {
                    System.out.println("The "+teams.get(teamB)+" defeated "+teams.get(teamA));
                    System.out.println("Final score "+totalTeamBScore+" - "+totalTeamAScore);
                    System.out.println();
                    System.out.println(teams.get(teamA)+" Are eliminated!");
                    teams.remove(teamA);
                    victory = true;
                }
                else {
                    victory = false;
                }
            }while(!victory || goldenSnitchWin);

        }
        return goldenSnitchWin;
    }
}
