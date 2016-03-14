package biz.golek.whattodofordinner.view.messages;

public class Dinner {
    private Long id;
    private String name;

    public Dinner(Long id, String name) {
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
