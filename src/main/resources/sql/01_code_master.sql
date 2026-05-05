DROP TABLE IF EXISTS code_master;

CREATE TABLE code_master (
    codeType varchar(50) NOT NULL,
    codeId varchar(50) NOT NULL,
    codeValue varchar(255),
    displayNo integer,
    createDateTime timestamp NOT NULL,
    createUser varchar(255) NOT NULL,
    updateDateTime timestamp,
    updateUser varchar(255),
    PRIMARY KEY (codeType, codeId)
);