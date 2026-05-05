-- テストユーザー：PW（TestUserAdmin123!）
INSERT INTO users (
    username,
    password,
    email1,
    deleteflag,
    authorityflag,
    createdatetime,
    createuser
)
VALUES (
    'テストユーザー',
    '$2a$10$OwCUha3Ep6PeTbIFbr9kIeJJftbVJsTsA5eqf0PCQ4aL519iLXY6m',
    'test@example.com',
    0,
    0,
    CURRENT_TIMESTAMP,
    'SYSTEM'
);