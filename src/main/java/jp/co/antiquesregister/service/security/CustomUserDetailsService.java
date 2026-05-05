package jp.co.antiquesregister.service.security;

import jp.co.antiquesregister.model.entity.User;
import jp.co.antiquesregister.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Spring Security ログイン時に実行する。
     * ログイン時のメールアドレスをキーに、ユーザ情報を取得しUserDetailsを返却。
     *
     * @param email ログイン時のメールアドレス。
     * @return UserDetails 認証成功。
     * @throws UsernameNotFoundException 認証失敗（401 Unauthorized）。
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail1(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "該当するユーザーが見つかりません: " + email));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail1(),
                user.getPassword(),
                Collections.emptyList()); // 権限は一旦空
    }
}
