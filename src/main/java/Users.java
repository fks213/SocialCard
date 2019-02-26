import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "passwd")
    private String passwd;

    public String getLogin(){
        return login;
    }

    public void setLogin(String log){
        this.login = log;
    }

    public String getPasswd(){
        return passwd;
    }

    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
}
