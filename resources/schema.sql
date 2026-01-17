CREATE TABLE IF NOT EXISTS categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    price NUMERIC(10,2) NOT NULL CHECK (price > 0),
    book_type VARCHAR(20) NOT NULL CHECK (book_type IN ('EBOOK','PRINTED')),
    file_size_mb NUMERIC(10,2),
    pages INT,
    category_id INT NOT NULL,
    CONSTRAINT fk_category FOREIGN KEY (category_id)
    REFERENCES categories(category_id)
    );

INSERT INTO categories(name) VALUES ('Programming')
    ON CONFLICT (name) DO NOTHING;

INSERT INTO categories(name) VALUES ('Math')
    ON CONFLICT (name) DO NOTHING;
