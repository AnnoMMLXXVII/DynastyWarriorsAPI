DROP TABLE IF EXISTS Kingdom;

CREATE TABLE IF NOT EXISTS Kingdom (
	name VARCHAR(6) NOT NULL PRIMARY KEY
);

INSERT INTO Kingdom (name) VALUES
	("Shu"),
    ("Wei"),
    ("Wu"),
    ("Jin"),
    ("Other");
    
SELECT * FROM Kingdom;
    