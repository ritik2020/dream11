import java.util.*;
import fantasy.*;

class Fantasy {
  public static void main(String[] args) {
      Wallet w1 = new Wallet(1000,10,3000);
      User ritik = new User(1, "Ritik", "ritik20023@gmail.com","9410622915",w1);
    
    //Real teams
   	  RealTeam India = new RealTeam("India");
      RealTeam England = new RealTeam("England");
      RealTeam RCB = new RealTeam("RCB");
    
    //Match
    RealTeam[] realTeams = new RealTeam[2];
    realTeams[0] = India;
    realTeams[1] = England;
    Match m1 = new Match("15-Feb-2021","08:00AM", "Test", realTeams);

    
    //players
    FantasyPlayer ViratKohli = new FantasyPlayer("Virat Kohli",10.5f, Arrays.asList(India, RCB));
    FantasyPlayer RohitSharma = new FantasyPlayer("Rohit Sharma",10.5f, Arrays.asList(India));
    FantasyPlayer JoeRoot = new FantasyPlayer("Joe Root",10.5f,Arrays.asList(England));
    
    //Fantasy Team
    FantasyTeam ft1 = new FantasyTeam(ritik, m1, Arrays.asList(ViratKohli,RohitSharma,JoeRoot));
    
    //contest
    float[] winningAmountDistributionPercentage = new float[1];
    winningAmountDistributionPercentage[0] = 100;
    Contest c1 = new Contest(500, 1300, 3, 3, 1, 5, winningAmountDistributionPercentage, 1, m1);
    
    System.out.println(w1.getWinningAmount());
    System.out.println(w1.getBonusAmount());
  	System.out.println(w1.getDepositAmount());
    
    

    c1.joinContest(ritik, ft1);
    
    System.out.println(w1.getWinningAmount());
    System.out.println(w1.getBonusAmount());
  	System.out.println(w1.getDepositAmount());
}
}

















