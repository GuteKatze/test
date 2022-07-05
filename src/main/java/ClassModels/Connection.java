package ClassModels;

import org.jetbrains.annotations.NotNull;

public class Connection {
    @NotNull
    private final String name;
    @NotNull
    private String url;
    @NotNull
    private String user;
    @NotNull
    private String pass;

    public Connection(String name, String url, String user, String pass) {
        this.name = name;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
