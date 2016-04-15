package com.natanielmendes.labs.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCUMENT")

public class Document implements Serializable {

    public static final class Queries {
        public static final String FIND_DOCUMENT = "FIND_DOCUMENT";
        public static final String FIND_DOCUMENTS_BY_USER = "FIND_DOCUMENTS_BY_USER";
        public static final String FIND_DOCUMENT_BY_TYPE = "FIND_DOCUMENT_BY_TYPE";
        public static final String FIND_ALL_DOCUMENT_BY_ENTITY = "FIND_ALL_DOCUMENT_BY_ENTITY";

    }

    //Attributes
    @Id
//    @GeneratedValue(generator="triggerGenerator")
//    @GenericGenerator(name="triggerGenerator", strategy="TriggerAssignedIdentityGenerator")
    @GeneratedValue
    @Column(name = "DOCUMENT_ID", nullable = false)
    private Long id;

    @Column(name = "ENTITY_ID")
    private Long entityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID", updatable = false, insertable = false)
    private UserEntity entity;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_TYPE_ID", insertable = false, updatable = false)
    private DocumentType documentType;

    @Column(name = "DOCUMENT_TYPE_ID")
    private Integer documentTypeId;


    //Constructors
    public Document() {
    }


    //Methods
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    //toString
    @Override
    public String toString() {
        return "DocumentDTO{" +
                "id=" + id +
                ", entityId=" + entityId +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentType=" + documentType +
                '}';
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public UserEntity getEntity() {
        return entity;
    }

    public void setEntity(UserEntity entity) {
        this.entity = entity;
    }
}