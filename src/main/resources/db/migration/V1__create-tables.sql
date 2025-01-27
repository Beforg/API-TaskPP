CREATE TABLE IF NOT EXISTS lists (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    deactivated BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tasks (
    id UUID PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    date VARCHAR(10) NOT NULL,
    completed BOOLEAN NOT NULL,
    list_id UUID,
    deactivated BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (list_id) REFERENCES lists(id)
);