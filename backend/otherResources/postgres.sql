CREATE TYPE role AS ENUM ('USER', 'ADMIN');
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_role role NOT NULL
);
