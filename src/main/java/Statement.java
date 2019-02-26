import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "statement")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Document document;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="data_id")
    private PersonalData personaldata;

    public Statement() {}


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public PersonalData getPersonaldata() {
        return personaldata;
    }

    public void setPersonaldata(PersonalData personaldata) {
        this.personaldata = personaldata;
    }
}