package com.lolspolls.app.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "polls")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = {@Builder})
public class PollEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false, insertable = false, updatable = false)
    private Date date;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;

    //
    // Relations
    //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity author;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "poll", cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

}
