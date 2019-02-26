import javax.persistence.*;

@Entity
@Table(name= "personaldata")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passnum")
    private String passnum;

    @Column(name = "seria")
    private String seria;

    @Column(name = "slid")
    private String slid;

    @OneToOne(mappedBy = "personaldata", fetch = FetchType.LAZY)
    private Statement statement;

    public PersonalData() {}

    public PersonalData(String passnum, String seria, String slid){
        this.passnum = passnum;
        this.seria = seria;
        this.slid = slid;
    }

    public void addStatement(Statement sttmnt) { statement = sttmnt; }

    public void removeStatement(Statement sttmnt) { statement = sttmnt; }

    public String getPassnum() {
        return passnum;
    }

    public void setPassnum(String passnum) {
        this.passnum = passnum;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getSlid() {
        return slid;
    }

    public void setSlid(String slid) {
        this.slid = slid;
    }
}