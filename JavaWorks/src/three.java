public class three {

    public static void main(String[] args){

        int groupOne, groupTwo;

        Bus one = new Bus();
        one.setNumberOfSeats(54);
        one.setCostOfSeat(400);

        Bus two = new Bus();
        two.setNumberOfSeats(45);
        two.setCostOfSeat(500);

        groupOne = 25;
        groupTwo = 30;
        int rentCost = 11000;

        for(int i = 0; i < groupOne + groupTwo; i++){
            if(i * one.getCostOfSeat() >= rentCost){
                one.setNumberOfOccupiedSeats(i);
                two.setNumberOfOccupiedSeats(groupOne + groupTwo - i);
                break;
            }
        }

        System.out.println(one.getNumberOfOccupiedSeats());
        System.out.println(two.getNumberOfOccupiedSeats());
    }

}

class Bus{
    int numberOfSeats, costOfSeat, numberOfOccupiedSeats = 0;

    public void setNumberOfSeats(int a){
        numberOfSeats = a;
    }

    public void setCostOfSeat(int b){
        costOfSeat = b;
    }

    public void setNumberOfOccupiedSeats(int c){
        numberOfOccupiedSeats = c;
    }

    public int getNumberOfSeats(){
        return numberOfSeats;
    }

    public int getCostOfSeat(){
        return costOfSeat;
    }

    public int getNumberOfOccupiedSeats(){
        return numberOfOccupiedSeats;
    }

    public void IsFree(){
        if(numberOfOccupiedSeats==numberOfSeats){
            System.out.println("Bus is completely occupied.");
        }
        if(numberOfOccupiedSeats==0){
            System.out.println("Bus is completely free.");
        }
        else{
            int freeSeats = numberOfSeats - numberOfOccupiedSeats;
            System.out.println("There is " + freeSeats + " free seats.");
        }
    }

    public int HowMuchMoney(){
        return costOfSeat * numberOfOccupiedSeats;
    }

    public boolean IsRentable() {
        if (costOfSeat * numberOfOccupiedSeats > 11000)
            return true;
        else
            return false;
    }
}