package biz.golek.whattodofordinner.view.messages;

/**
 * Created by bgolek on 2016-02-10.
 */
public class DinnerDeletedMessage {
    private Long id;

    public DinnerDeletedMessage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
