package fantasy;
import java.util.List;
import java.util.ArrayList;
public class Contest{
    int entryFee; //500
    int winningAmount; //2300
    int maxTeams; //5
    int minTeams; //5
    int winnersCount; //2
    int bonusPercent;
    Match match;
    float[] winningAmountDistributionPercentage; //[70,30]
    float[] winningAmountForEachWinner; //[1610,690]
    int maxFantasyTeamsPerUser; //false
    List<FantasyTeam> fantasyTeams; 
    
    public Contest(int entryFee, int winningAmount, int maxTeams, int minTeams, int winnersCount, int bonusPercent,
            float[] winningAmountDistributionPercentage, int maxFantasyTeamsPerUser, Match match){
      this.entryFee = entryFee;
      this.winningAmount = winningAmount;
      this.maxTeams = maxTeams;
      this.minTeams = minTeams;
      this.winnersCount = winnersCount;
      this.bonusPercent = bonusPercent;
      this.match = match;
      this.winningAmountDistributionPercentage = winningAmountDistributionPercentage;
      this.winningAmountForEachWinner = this.calculateWinningAmountForEachWinner();
      this.maxFantasyTeamsPerUser = maxFantasyTeamsPerUser;
      this.fantasyTeams = new ArrayList<>();
    }
    
    public void updateRankOfEachFantasyTeam(){
      
    }
    
    public boolean joinContest(User user,FantasyTeam team){
      if(this.isFilled()){return false;}
      if(!isSufficientAmount(user.wallet, this.entryFee)){return false;}
      if(fantasyTeamsAlreadyJoinedByUser(user)>=this.maxFantasyTeamsPerUser){return false;}
      
      this.debitAmountFromWallet(user.wallet, this.entryFee);
      this.fantasyTeams.add(team);
      return true;
    }
    
    private void debitAmountFromWallet(Wallet wallet, int amount){
      float usableBonusAmount = amount*((float)this.bonusPercent/100); //100
      float maxBonusToBeDeducted = Math.min(usableBonusAmount,wallet.getBonusAmount());
      wallet.debitBonus(maxBonusToBeDeducted);
      
      float remainingAmount = amount-maxBonusToBeDeducted;
      float maxDepositToBeDeducted = Math.min(remainingAmount,wallet.getDepositAmount());
      wallet.debitDeposit(maxDepositToBeDeducted);
      
      remainingAmount = remainingAmount - maxDepositToBeDeducted;
      wallet.debitWinnings(remainingAmount);
    }
    
    private boolean isSufficientAmount(Wallet wallet, int amount){
     float usableBonusAmount = amount*((float)this.bonusPercent/100); 
     float remainingAmount = amount - Math.min(usableBonusAmount,wallet.getBonusAmount());
     float totalWalletAmountExcludingBonus = wallet.getWinningAmount() + wallet.getDepositAmount();
     if(remainingAmount<=totalWalletAmountExcludingBonus){
       return true;
     }else{
       return false;
     }
    }
    
    private float[] calculateWinningAmountForEachWinner() {
      float[] res = new float[this.winnersCount];
      for(int i=0; i<res.length; i++){
        float winningAmount = this.winningAmount * (this.winningAmountDistributionPercentage[i]/100);
        res[i] = winningAmount;
      }
      return res;
    }
    
      
    private boolean isFilled(){
      return this.fantasyTeams.size()==this.maxTeams;
    }
    
    private int fantasyTeamsAlreadyJoinedByUser(User user){
      int count = 0;
      for(int i=0; i<fantasyTeams.size(); i++){
        User userAtIndex = fantasyTeams.get(i).user;
        if(userAtIndex.id==user.id){
          count++;
        }
      }
      return count;
    }
  }