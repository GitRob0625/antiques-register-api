package jp.co.antiquesregister.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity {

    /** 作成日時 */
    @CreatedDate
    @Column(name = "createdatetime", nullable = false, updatable = false)
    private LocalDateTime createDateTime;

    /** 更新日時 */
    @LastModifiedDate
    @Column(name = "updatedatetime", nullable = false)
    private LocalDateTime updateDateTime;
}
