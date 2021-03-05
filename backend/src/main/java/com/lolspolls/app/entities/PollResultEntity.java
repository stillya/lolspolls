package com.lolspolls.app.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "polls_results")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = {@Builder})
public class PollResultEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "poll_id", nullable = false)
    private UUID pollId;

    //
    // Relations
    //

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poll_id", insertable = false, updatable = false)
    private PollEntity poll;

}
