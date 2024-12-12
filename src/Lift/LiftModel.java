package Lift;

class LiftModel {
    private LiftView view;
    private int[] liftPosition;

    LiftModel(LiftView view) {
        this.view = view;
        liftPosition = new int[5];
    }

    public void displayLiftPosition() {
        for (int i = 0; i < liftPosition.length; i++) {
            view.display("L" + (i + 1) + ": " + liftPosition[i]);
        }
        System.out.println();
    }

    public void assignLift(int passengerFloor, int destinationFloor) {
        liftPosition[0] = destinationFloor;
        view.display("L1 is assigned");
    }

    public void assignNearestLift(int passengerFloor, int destinationFloor) {
        int smallest = 0;
        for (int i = 1; i < liftPosition.length; i++) {
            if (Math.abs(passengerFloor - liftPosition[i]) < Math.abs(passengerFloor - liftPosition[smallest])) {
                smallest = i;
            }
        }
        liftPosition[smallest] = destinationFloor;
        view.display("L" + (smallest + 1) + " is nearest to passenger");
    }

    public void assignLiftInSameDirection(int passengerFloor, int destinationFloor) {
        int smallest = -1;
        int smallVal = Integer.MAX_VALUE;
        // Up-Direction
        if(passengerFloor < destinationFloor) {
            for (int i = 0; i < liftPosition.length; i++) {
                if(liftPosition[i] < passengerFloor && Math.abs(liftPosition[i]-passengerFloor)<smallVal) {
                    smallest = i;
                    smallVal = Math.abs(liftPosition[i]-passengerFloor);
                }
            }

        }
        //Down-Direction
        else {
            for (int i = 0; i < liftPosition.length; i++) {
                if(liftPosition[i] >= passengerFloor && Math.abs(liftPosition[i]-passengerFloor)<smallVal) {
                    smallest = i;
                    smallVal = Math.abs(liftPosition[i]-passengerFloor);
                }
            }
        }
        if(smallest == -1) {
            view.display("There is no lift in that direction");
        } else {
            liftPosition[smallest] = destinationFloor;
            view.display("L" + (smallest + 1) + " is nearest and in the same direction");
        }
    }
}
