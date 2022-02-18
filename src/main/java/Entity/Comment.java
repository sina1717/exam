package Entity;

public class Comment {
    private Integer id;
    private Account account;
    private Post post;
    private String description;

    public Comment(Integer id, Account account, Post post, String description) {
        this.id = id;
        this.account = account;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
