package singleton.work;

public enum EnumCalcTool {
    INSTANCE;
    
    private static int totalBMICalculated = 0;
    private static int numberOfCaculations = 0;
    
    private EnumCalcTool(){
        
        
    }
    
     public double calcBMI(double height, double weight, MeasurementSystem measurementSystem) {
        double bmi = weight / Math.pow(height, 2);
        if (measurementSystem == MeasurementSystem.ENGLISH) {
            bmi *= 703;
        }
        totalBMICalculated += bmi;
        numberOfCaculations++;

        return bmi;
    }
     
     public double averageBMI() {
        return totalBMICalculated / numberOfCaculations;
    }

}
