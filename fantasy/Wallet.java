package fantasy;
public class Wallet{
    private float winningAmount;
    private float bonusAmount;
    private float depositAmount;

    public float getWinningAmount(){
      return this.winningAmount;
    }
    public void setWinningAmount(float amount){
      this.winningAmount = amount;
    }
    public float getBonusAmount(){
      return this.bonusAmount;
    }
    public void setBonusAmount(float amount){
      this.bonusAmount = amount;
    }
    public float getDepositAmount(){
      return this.depositAmount;
    }
    public void setDepositAmount(float amount){
      this.depositAmount = amount;
    }
    
    public Wallet(float winningAmount, float bonusAmount, float depositAmount){
      this.winningAmount = winningAmount;
      this.bonusAmount = bonusAmount;
      this.depositAmount = depositAmount;
    }

    public void debitBonus(float amountToDebit){
      this.bonusAmount = this.bonusAmount - amountToDebit;
    }
    public void debitDeposit(float amountToDebit){
      this.depositAmount = this.depositAmount - amountToDebit;
    }
    public void debitWinnings(float amountToDebit){
      this.winningAmount = this.winningAmount - amountToDebit;
    }
   }
  
