package Entity;

public class Post {
    private Integer id;
    private Account account;
    private String description;

    public Post(Integer id, Account account, String description) {
        this.id = id;
        this.account = account;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
