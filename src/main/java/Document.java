import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name= "doctype")
    private String doctype;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Statement> statements;

    public Document() {}

    public Document(String name, String doctype){
        this.name = name;
        this.doctype = doctype;
        statements = new ArrayList<Statement>();
    }

    public void addStatement(Statement statement) {
        statements.add(statement);
    }

    public void removeStatement(Statement statement) {
        statements.remove(statement);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }
}