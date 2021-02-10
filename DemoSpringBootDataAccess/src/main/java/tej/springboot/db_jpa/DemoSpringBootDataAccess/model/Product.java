package tej.springboot.db_jpa.DemoSpringBootDataAccess.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @Column(name = "ROW_CREAT_TS", insertable = true, updatable = false)
    @CreationTimestamp
    private Date rowCreatTs;

    @Column(name = "ROW_UPDATE_TS", insertable = false, updatable = true)
    @UpdateTimestamp
    private Date rowUpdateTs;

    public Product() {
    }

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getRowCreatTs() {
        return rowCreatTs;
    }

    public void setRowCreatTs(Date rowCreatTs) {
        this.rowCreatTs = rowCreatTs;
    }

    public Date getRowUpdateTs() {
        return rowUpdateTs;
    }

    public void setRowUpdateTs(Date rowUpdateTs) {
        this.rowUpdateTs = rowUpdateTs;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
