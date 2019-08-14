package com.taichi.cfm.domain.data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int YES = 1;
    public static final int NO = 0;

    public static final int DELETED = 1;
    public static final int UNDELETED = 0;

    @Id
    @GeneratedValue
    protected Long id;

    public Long getId() {
        return id;
    }

    /**
     * Returns if the {@code Persistable} is new or was persisted already.
     *
     * @return if the object is new
     */
    public void setId(Long id) {
        this.id = id;
    }

}
