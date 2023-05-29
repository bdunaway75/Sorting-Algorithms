public class example {
    public static void main(String[] args){
        Model model = new Model(1080,1920);
        View view = new View();
        Controller controller = new Controller(model, view);
        model.registerObserver(controller);
        model.Randomize();
        model.sortColumns();
        model.Randomize();
        model.sortRows();
        model.Randomize();
        model.sortArray1();
        model.Randomize();
        model.sortArray2();

    }
}
