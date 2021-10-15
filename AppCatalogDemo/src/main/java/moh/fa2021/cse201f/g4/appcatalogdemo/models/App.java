package moh.fa2021.cse201f.g4.appcatalogdemo.models;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Document(collection = "app")
public class App {
    @Id
    private String id;

    @Size(max = 20)
    @TextIndexed
    @Indexed
    private String name;

    @Size(max = 20)
    private String org;

    @Size(max = 1000)
    private String description;

    @Size(max = 20)
    private String androidLink;

    @Size(max = 20)
    private String iOSLink;

    @Size(max = 20)
    private String pcLink;


    private boolean approveStatus;

    public App() {
    }

    public App(String name, String org, String description, String androidLink, String iOSLink, String pcLink, boolean approveStatus) {
        this.name = name;
        this.org = org;
        this.description = description;
        this.androidLink = androidLink;
        this.iOSLink = iOSLink;
        this.pcLink = pcLink;
        this.approveStatus = approveStatus;
    }

    public App(String name, String org, String description) {
        this(name,org,description,null,null,null,true);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAndroidLink() {
        return androidLink;
    }

    public void setAndroidLink(String androidLink) {
        this.androidLink = androidLink;
    }

    public String getiOSLink() {
        return iOSLink;
    }

    public void setiOSLink(String iOSLink) {
        this.iOSLink = iOSLink;
    }

    public String getPcLink() {
        return pcLink;
    }

    public void setPcLink(String pcLink) {
        this.pcLink = pcLink;
    }

    public boolean isApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(boolean approveStatus) {
        this.approveStatus = approveStatus;
    }
}
