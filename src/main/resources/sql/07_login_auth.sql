DROP TABLE IF EXISTS login_auth;

CREATE TABLE login_auth (
    userId integer PRIMARY KEY,
    authCode varchar(6),
    authCodeSendDateTime timestamp,
    loginDateTime timestamp,
    createDateTime timestamp NOT NULL,
    createUser varchar(255) NOT NULL,
    updateDateTime timestamp,
    updateUser varchar(255),
    CONSTRAINT fk_login_auth_user
    FOREIGN KEY (userId) REFERENCES users(userId)
);