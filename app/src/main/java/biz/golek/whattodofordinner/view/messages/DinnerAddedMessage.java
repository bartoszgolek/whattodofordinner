package biz.golek.whattodofordinner.view.messages;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class DinnerAddedMessage {
    private Dinner[] dinners;

    public DinnerAddedMessage(Dinner[] dinners) {

        this.dinners = dinners;
    }

    public Dinner[] getAddedDinners() {
        return dinners;
    }
}

