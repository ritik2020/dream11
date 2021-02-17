package fantasy;
public class Match {
    String date;
    String time;
    String type;
    RealTeam[] realTeams;
    String status;
    public Match(String date, String time, String type, RealTeam[] realTeams){
      this.date = date;
      this.time = time;
      this.type = type;
      this.realTeams= realTeams;
    }
  }