import java.util.Random;

public class Dice {

        private int dice1stResult, dice2ndResult;
        
        public int rollDiceResult1(){   
                Random random = new Random();
                setDice1stResult(random.nextInt(6)+ 1);
                System.out.println("diceResult1: " + dice1stResult);
                return getDice1stResult();
        }       
                
        public int rollDiceResult2(){   
                Random random = new Random();
                setDice2ndResult(random.nextInt(6) + 1);
                System.out.println("diceResult2: " + dice2ndResult);
                return dice2ndResult;
        }

        ///////////////GETTER and SETTER ///////////////
        
        
        public void setDice1stResult(int dice1stResult) {
                this.dice1stResult = dice1stResult;
        }

        public int getDice1stResult() {
                return dice1stResult;
        }

        public void setDice2ndResult(int dice2ndResult){
                this.dice2ndResult = dice2ndResult;
        }
        public int getDice2ndResult() {
                return dice2ndResult;
        }
                
        
}