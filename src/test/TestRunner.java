package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(AddObstacleTest.class, ObstacleCollisionBehaviorTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            System.err.println(failure.getTrace());
        }

        System.out.println(result.wasSuccessful());
    }
}  	