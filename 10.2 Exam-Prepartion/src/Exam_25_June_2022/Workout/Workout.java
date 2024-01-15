package Exam_25_June_2022.Workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    //type: String
    //exerciseCount: int
    //exercises : List <Exercise>
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    //Method addExercise(Exercise exercise) – adds an entity to the exercises
    // If there is still space on the workout sheet (exerciseCount).
    public void addExercise(Exercise exercise) {
        if (this.exerciseCount > this.exercises.size()) {
            this.exercises.add(exercise);
        }
    }

    //Method removeExercise(String name, String muscle) – removes the exercise
    // by given name and muscle, if such exists, and returns boolean.
    public boolean removeExercise(String name, String muscle) {
        for (int i = 0; i < this.exercises.size(); i++) {
            Exercise exercise = this.exercises.get(i);
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return this.exercises.remove(exercise);
            }
        }
        return false;
    }

    //Method getExercise(String name, String muscle) – returns the exercise with the
    // given name and muscle or null if there is no such exercise.
    public Exercise getExercise(String name, String muscle) {
        Exercise exercise = null;
        for (int i = 0; i < this.exercises.size(); i++) {
            exercise = this.exercises.get(i);
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    //Method getMostBurnedCaloriesExercise() – returns the exercise which is burned the
    // most calories or null if there are no exercises.
    public Exercise getMostBurnedCaloriesExercise() {
        if (this.exercises.size() > 0) {
            Exercise exercise = this.exercises.get(0);
            for (int i = 1; i < this.exercises.size(); i++) {
                Exercise current = this.exercises.get(i);
                if (exercise.getBurnedCalories() < current.getBurnedCalories()) {
                    exercise = current;
                }
            }
            return exercise;
        } else return null;
    }

    //Getter getExerciseCount() – returns the number of exercises.
    public int getExerciseCount() {
        return exerciseCount;
    }

    //getStatistics() – returns a String in the following format:
    //"Workout type: {workout type}
    //Exercise: {Exercise1}
    //Exercise: {Exercise2}
    //(…)"
    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Workout type: %s", this.type));
        for (int i = 0; i < this.exercises.size(); i++) {
            result.append(System.lineSeparator());
            result.append(this.exercises.get(i).toString());
        }
        return result.toString();
    }
}
