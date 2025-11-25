package jp.co.antiquesregister.repository;

import jp.co.antiquesregister.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * メールアドレスをキーに、ユーザ情報を取得する。
     * @param email 検索するメールアドレス
     */
    Optional<User> findByEmail(@Param("email") String email);
}

