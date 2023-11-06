package ma.ensa.inscription.beans;

import java.util.List;

public class Role {
    private Long id;
    private List<User> users;
    private String name;
    public Role() {
        super();
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
