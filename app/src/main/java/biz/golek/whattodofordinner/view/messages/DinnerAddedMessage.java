package biz.golek.whattodofordinner.view.messages;

/**
 * Created by bgolek on 2016-02-10.
 */
public class DinnerAddedMessage {
    private Long id;
    private String name;

    public DinnerAddedMessage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}