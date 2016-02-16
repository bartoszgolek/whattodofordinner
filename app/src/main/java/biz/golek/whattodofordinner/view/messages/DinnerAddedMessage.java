package biz.golek.whattodofordinner.view.messages;

/**
 * Created by bgolek on 2016-02-10.
 */
public class DinnerAddedMessage {
    private AddedDinner[] dinners;

    public DinnerAddedMessage(AddedDinner[] dinners) {

        this.dinners = dinners;
    }

    public AddedDinner[] getAddedDinners() {
        return dinners;
    }
}

