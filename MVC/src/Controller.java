public class Controller implements Observer {
    Model model;
    View view;
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        model.registerObserver(this);
    }

    public static void main(String[] args){
    }


    @Override
    public void update() {
        view.getDataAndVisualizeIt(model.getArr(), model.height, model.width);
    }
}
