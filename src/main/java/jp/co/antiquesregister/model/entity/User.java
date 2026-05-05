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
public class User extends AbstractAuditingEntity {

    /** ユーザID（主キー） */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long id;

    /** ユーザー名 */
    @Column(name = "username", nullable = false)
    private String name;

    /** パスワード（ハッシュ値） */
    @Column(name = "password", nullable = false)
    private String password;

    /** Eメール１ */
    @Column(name = "email1", nullable = false)
    private String email1;

    /** 削除フラグ */
    @Column(name = "deleteflag", nullable = false)
    private Integer deleteFlag;

    /** 権限フラグ */
    @Column(name = "authorityflag", nullable = false)
    private Integer authorityFlag;

    /** 作成者 */
    @Column(name = "createuser", nullable = false)
    private String createUser;

    /** 更新者 */
    @Column(name = "updateuser")
    private String updateUser;
}