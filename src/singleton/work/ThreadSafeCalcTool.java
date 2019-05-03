package singleton.work;

public class ThreadSafeCalcTool {
    
    private static ThreadSafeCalcTool instance = null;
    
    private static int totalBMICalculated = 0;
    private static int numberOfCaculations = 0;
    
     private ThreadSafeCalcTool() {
        try {
            // Simulate a long-running constructor, maybe a network or database call?
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
        }
     }
    
     public static double calcBMI(double height, double weight, MeasurementSystem measurementSystem) {
        double bmi = weight / Math.pow(height, 2);
        if (measurementSystem == MeasurementSystem.ENGLISH) {
            bmi *= 703;
        }
        totalBMICalculated += bmi;
        numberOfCaculations++;

        return bmi;
    }

    public static double averageBMI() {
        return totalBMICalculated / numberOfCaculations;
    }
    
    public synchronized static ThreadSafeCalcTool getInstance() {
        // Double locking
        if (instance == null) {
            synchronized (ThreadSafeCalcTool.class) {
                if (instance == null) {
                    instance = new ThreadSafeCalcTool();
                }
            }
        }

        return instance;
    }
    
}
