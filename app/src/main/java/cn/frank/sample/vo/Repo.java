package cn.frank.sample.vo;

public class Repo {

    private String id;
    private String full_name;
    private String description;

    public Repo(String id, String full_name, String description) {
        this.id = id;
        this.full_name = full_name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
