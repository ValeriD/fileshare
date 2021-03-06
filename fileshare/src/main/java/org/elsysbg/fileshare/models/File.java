package org.elsysbg.fileshare.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "file_type", length = 100)
    private String fileType;

    @JsonIgnore
    @Lob
    private byte[] data;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User belongsTo;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.REMOVE)
    private Set<File> files;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "parent_id")
    private File parent;

    @JsonIgnore
    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    Set<Link> links;

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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public User getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(User belongsTo) {
        this.belongsTo = belongsTo;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public File getParent() {
        return parent;
    }

    public void setParent(File parent) {
        this.parent = parent;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }
}
