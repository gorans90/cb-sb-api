package com.carbook.models.projects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gsimic on 10/21/2017.
 */

@Entity(name = "image")
public class Image implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    private Project project;

    public Image() {};

    public Image(Integer id, String path, Project project) {
        this.id = id;
        this.path = path;
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
