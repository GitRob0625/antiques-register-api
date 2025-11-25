package jp.co.antiquesregister.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@SQLRestriction("delete_date IS NULL")
public class User extends AbstractAuditingEntity {

    /** ユーザID（主キー） */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** メールアドレス */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /** パスワードハッシュ値 */
    @Column(name = "password", nullable = false)
    private String password;

    /** ユーザ名 */
    @Column(name = "name", nullable = false)
    private String name;

    /** 論理削除日時 */
    @Column(name = "delete_date")
    private LocalDateTime deleteDate;
}