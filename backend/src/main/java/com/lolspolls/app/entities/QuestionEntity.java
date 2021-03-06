package com.lolspolls.app.entities;

import java.util.Set;
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
@Table(name = "questions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = {@Builder})
public class QuestionEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hint")
    private String hint;

    @Column(name = "element_type", nullable = false)
    private String type;

    @Column(name = "poll_id", nullable = false)
    private UUID pollId;

    //
    // Relations
    //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poll_id", insertable = false, updatable = false)
    private PollEntity poll;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    private Set<ElementEntity> elements;

}
