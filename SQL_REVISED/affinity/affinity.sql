DROP TABLE IF EXISTS Affinity;

CREATE TABLE IF NOT EXISTS Affinity ( 
    type VARCHAR ( 6 ) NOT NULL PRIMARY KEY 
);


INSERT INTO Affinity (type) VALUES 
    ("Heaven"),
    ("Earth"),
    ("Man");