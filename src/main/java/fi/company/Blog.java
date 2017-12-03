package fi.company;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated blog ID")
    private Long id;
    @ApiModelProperty(notes = "The author of the blog")
    private String name;
    @ApiModelProperty(notes = "The title of the blog")
    private String title;
    @Column(length=1000)
    @ApiModelProperty(notes = "The body of the blog")
    private String body;

    public Blog() {
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
