CREATE TABLE IF NOT EXISTS users
(
    id                  UUID            NOT NULL,
    username            VARCHAR(255)    NOT NULL,
    name                VARCHAR(255)    NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS polls
(
    id          UUID         NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT         NOT NULL,
    date        TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    owner_id    UUID         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT poll_user FOREIGN KEY (owner_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS questions
(
    id                  UUID            NOT NULL,
    poll_id             UUID            NOT NULL,
    name                TEXT            NOT NULL,
    element_type        VARCHAR(255)    NOT NULL,
    hint                TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (poll_id) REFERENCES polls (id)
);

CREATE TABLE IF NOT EXISTS elements
(
    id                  UUID            NOT NULL,
    question_id         UUID            NOT NULL,
    value               UUID            NOT NULL,
    required            BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES questions (id)
);

CREATE TABLE IF NOT EXISTS polls_results
(
    id                  UUID            NOT NULL,
    poll_id             UUID            NOT NULL,
    content             TEXT            NOT NULL,
    responders_count    INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (poll_id) REFERENCES polls (id)
);




