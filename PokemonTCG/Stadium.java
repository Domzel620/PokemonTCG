public class Stadium {
    
    public void battle(Pokemon p1, Pokemon p2){
        //Normally check speed first

        //Put this in a loop until one is knocked out Bag
        // Battle Math subtract from hp the ifference of attack and defense
        //pokemon one attack pokemon 2
        //pokemon two attacks pokemon 1
        while(p1.getHp() > 0  && p2.getHp() > 0 ){
        if (p1.getSpeed() > p2.getSpeed()){
            p2.setHp(p2.getHp() - (p1.getAttack() - p2.getDefense()));
            System.out.println("P2 was hit by tackle hes now at: " + p2.getHp());
        } else{
            p1.setHp(p1.getHp() - (p2.getAttack() - p1.getDefense()));
            System.out.println("P1 was hit by tackle hes now at: " + p1.getHp());
        }
        }
        if (p1.getHp() <= 0){
            System.out.println("Pokemon 1 lost");
        }else{
            System.out.println("Pokemon 2 Lost");
        }
    
    }



}
