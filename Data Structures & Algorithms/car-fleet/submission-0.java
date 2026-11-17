class Solution {
    class CarState{
        int distanceFromTarget;
        int speed;
        double timeToReach;

        CarState(int distanceFromTarget,int speed,double timeToReach){
            this.distanceFromTarget = distanceFromTarget;
            this.speed = speed;
            this.timeToReach = timeToReach;
        }
    }


    public int carFleet(int target, int[] position, int[] speed) {
        List<CarState> carstates = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            CarState newObj = new CarState(target-position[i],speed[i],
            (1.0)*(target-position[i])/speed[i]);
            carstates.add(newObj);
        }

        carstates.sort((a, b) -> a.distanceFromTarget-b.distanceFromTarget);


        int fleetCount = 0;
        double currTime = 0.0;

        for(int i=0;i<carstates.size();i++){
            if(carstates.get(i).timeToReach>currTime){
                currTime = carstates.get(i).timeToReach;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
