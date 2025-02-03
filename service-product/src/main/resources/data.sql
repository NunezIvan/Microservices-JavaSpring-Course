CREATE TABLE IF NOT EXISTS tbl_categories (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS tbl_products (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255),
    description VARCHAR(255),
    stock DOUBLE,
    price DOUBLE,
    status VARCHAR(255),
    create_at TIMESTAMP,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES tbl_categories(id)
    );


INSERT INTO tbl_categories (id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categories (id, name) VALUES (2, 'books');
INSERT INTO tbl_categories (id, name) VALUES (3, 'electronics');

INSERT INTO tbl_products (name, description, stock,price,status, create_at,category_id)
VALUES ('adidas Cloudfoam Ultimate','Walk in the air in the black black CLOUDFOAM ULTIMATE running shoe from ADIDAS',5,178.89,'CREATED','2018-09-05',1);

INSERT INTO tbl_products (name, description, stock,price,status, create_at,category_id)
VALUES ('under armour Men ','s Micro G Assert – 7 under armour Men Lightweight mesh upper delivers complete breathability Durable leather overlays for stability ',4,12.5,'CREATED','2018-09-05',1);


INSERT INTO tbl_products (name, description, stock,price,status, create_at,category_id)
VALUES ('Spring Boot in Action','under armour Men Craig Walls is a software developer at Pivotal and is the author of Spring in Action',12,40.06,'CREATED','2018-09-05',2);