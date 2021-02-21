package com.lolspolls.app.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lolspolls.app.dto.types.ElementTypeEnum;
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
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = {@Builder})
public class QuestionEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hint")
    private String hint;

    @Column(name = "element_type", nullable = false)
    private ElementTypeEnum type;

    @Column(name = "poll_id", nullable = false)
    private UUID pollId;

    //
    // Relations
    //

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "elements")
    private List<ElementEntity> elements;

}
