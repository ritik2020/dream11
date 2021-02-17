package fantasy;
import java.util.List;
public class FantasyPlayer{
    String name;
    float credits;
    float c_points;
    List<RealTeam> realTeams;
    public FantasyPlayer(String name, float credits, List<RealTeam> realTeams){
      this.name = name;
      this.credits = credits;
      this.realTeams = realTeams;
      this.c_points = 0;
    }
  }
