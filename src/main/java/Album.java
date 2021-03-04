public class Album {

    private Integer userId;
    private Integer id;
    private String title;

    /**
     * No args constructor for use in serialization
     */
    public Album() {
    }

    /**
     * @param id
     * @param title
     * @param userId
     */
    public Album(Integer userId, Integer id, String title) {
        super();
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

