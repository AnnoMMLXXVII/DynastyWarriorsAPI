DROP TABLE IF EXISTS Attribute_Special;

CREATE TABLE IF NOT EXISTS Attribute_Special ( 
    name        VARCHAR ( 15 ) NOT NULL PRIMARY KEY,
    description VARCHAR (69) NOT NULL
);

INSERT INTO Attribute_Special VALUES
    ("Awareness" , "Can block attacks from the rear" ),
    ("Desperation", "Doubles attack power when in critical condition"),
    ("Resolve", "Doubles defense power when in critical condition"),
    ("Switftness", "Doubles movement speed when in critical condition"),
    ("Agility", "Releases a damaging war cry when recovering from an attack in mid-air"),
    ("Greed", "Produces money by attack blocking enemies"),
    ("Fury", "Enables the use of True Mosou regardless of health"),
    ("Rigidity", "The user's guard cannot be broke by any attack"),
    ("Battleaxe", "Doubles attack power momentarily upon defeating 50 enemies"),
    ("Armor Sleeve", "Doubles defense power momentarily upon defeating 50 enemies"),
    ("War Shoes", "Doubles movement speed momentarily upon defeating 50 enemies"),
    ("Rakshasa", "Lowers health, but increases strength while crushing enemies"),
    ("Shining Warrior", "Raises attack pwoer the more allies are nearby");