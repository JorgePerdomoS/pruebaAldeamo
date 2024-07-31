CREATE TABLE arrays
(   id  INT PRIMARY KEY,
    input_array VARCHAR(255) NOT NULL
);

INSERT INTO arrays (id, input_array)
VALUES (1, '2,4,5,6,7,8'),
       (2, '3,7,9,5,4,2'),
       (3, '5,7,9,11,13'),
       (4, '6,4,2,12,15'),
       (5, '7,10,15,11,9');

ALTER TABLE arrays
    ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE arrays
    ALTER COLUMN id RESTART WITH 6;