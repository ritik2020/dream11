package fantasy;
import java.util.List;
import java.lang.Comparable;
public class FantasyTeam implements Comparable<FantasyTeam>{
    List<FantasyPlayer> fantasyPlayers;
    User user;
    Match match;
    float points;
    public FantasyTeam(User user, Match match, List<FantasyPlayer> fantasyPlayers){
      this.user = user;
      this.match = match;
      this.fantasyPlayers = fantasyPlayers;
      this.points = 0;
    }

    public int compareTo(FantasyTeam fantasyTeam){
	  if(fantasyTeam.points!=this.points){
	    if(fantasyTeam.points>this.points){
	      return -1;
	    }else{
	      return 1;
	    }
	  }else{
	    return 0;
	  }
	}
  }
