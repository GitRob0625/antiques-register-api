<<<<<<< HEAD:src/main/resources/sql/InsertTestData.sql
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
=======
-- users
INSERT INTO users (name, email, password)
VALUES ('テストユーザー', 'test@example.com', '$2a$10$N9qPP773ZD.NDHXVja033./tulB5ELlddTNt7gpMClRLr7VA0ajXC');

>>>>>>> 2873120ad027fc426f02ed512e4fd273120e4445:src/main/resources/sql/data/InsertTestData.sql
