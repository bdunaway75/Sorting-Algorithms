import java.util.*;

public class Model implements Subject {
    List<Observer> observers;   // List to store the observers
    int height;                 // Height of the array
    int width;                  // Width of the array
    int[][] arr;                // 2D array to store the data

    // Constructor to initialize the model
    public Model(int width, int height){
        this.height = height;
        this.width = width;
        arr = new int[width][height];
        observers = new ArrayList<Observer>();
    }

    // Method to get the array
    public int[][] getArr(){
        return arr;
    }

    // Method to randomly populate the array
    public void Randomize(){
        Random r = new Random();
        for(int i = 0; i < width ; i++){
            for(int j = 0; j < height ; j++) {
                arr[i][j] = r.nextInt(255 - (-255)) + (-255);
            }
        }
    }

    // Method to sort the columns of the array
    public void sortColumns(){
        for(int k = 0; k < height; k++) {
            for (int j = 1; j < width; j++) {
                for (int i = j; i >= 1; i--) {
                    if (arr[i - 1][k] > arr[i][k]) {
                        int tmp = arr[i - 1][k];
                        arr[i - 1][k] = arr[i][k];
                        arr[i][k] = tmp;
                    }
                }
            }
            notifyObservers();
        }
    }

    // Method to sort the rows of the array
    public void sortRows(){
        for(int k = 0; k < width; k++) {
            for (int j = 1; j < height; j++) {
                for (int i = j; i >= 1; i--) {
                    if (arr[k][i-1] > arr[k][i]) {
                        int tmp = arr[k][i-1];
                        arr[k][i-1] = arr[k][i];
                        arr[k][i] = tmp;
                    }
                }
            }
            notifyObservers();
        }
    }

    // Method to sort the array by sorting columns first and then rows
    public void sortArray1(){
        sortColumns();
        sortRows();
    }

    // Method to sort the array by sorting rows first and then columns
    public void sortArray2(){
        sortRows();
        sortColumns();
    }

    // Method to register an observer
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // Method to remove an observer
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // Method to notify all observers
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}