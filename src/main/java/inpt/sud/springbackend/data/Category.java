package inpt.sud.springbackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Category implements Serializable{



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products ;

    public String getName(String whatever){
        return this.name;
    }
    public String SetName(){
        return this.name;
    }
}
