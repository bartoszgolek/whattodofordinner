package biz.golek.whattodofordinner.view.messages;

/**
 * Created by bg on 09.03.16.
 */
public class DinnerLoadedMessage {
    private Dinner[] dinners;

    public DinnerLoadedMessage(Dinner[] dinners) {

        this.dinners = dinners;
    }

    public Dinner[] getDinners() {
        return dinners;
    }
}
