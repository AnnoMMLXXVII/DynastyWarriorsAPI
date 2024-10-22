DROP TABLE IF EXISTS Attribute_Normal;

CREATE TABLE IF NOT EXISTS Attribute_Normal ( 
    name VARCHAR ( 15 ) NOT NULL PRIMARY KEY,
    description VARCHAR(92) NOT NULL
);

INSERT INTO Attribute_Normal VALUES
    ("Thorns",     "Inflicts a portion of damage received against the enemy"),
    ("Velocity",   "Raises overall attack speed"),
    ("Cyclone",    "Inflicts chip damage against blocking enemies, and deals percentage damage of their total HP"),
    ("Slash",      "May instantly defeat any enemies while also greatly damage enemy officers out of chance"),
    ("Recovery",   "Heals the user with each attack"),
    ("Thunder",    "Electrocutes enemies, doing additional damage against them while stunning them"),
    ("Whirlwind",  "Raises damage caused by knock back attacks"),
    ("Frost",      "Freezes enemies, preventing them from moving momentarily"),
    
    ("Survival",   "Raises attack power while lowering overall health"),
    ("Frenzy",     "Raises attack power while lowering overall defense"),
    ("Barricade",  "Raises defense power while lowering overall defense"),
    ("Aggression", "Raises damage done by Musou attacks"),
    ("Flurry",     "Raises damange as combos go up"),
    ("Chain",      "Increases time period for maintaing combo count"),
    ("Inferno",    "Burns enemies, gradually diminishing their health over time"),
    ("Venom",      "Poisons Enemies, leaving them weakened momentariy"),
    ("Flash",      "Causes affected foes to explode, inflicting damage to other enemies nearby"),
    ("Spurt",      "Raises the chances of enemies dropping the winged boots power-up"),
    ("Uplift",     "Attacks help fill up the Musou gauge"),
    ("Enlightenment", "Attacks helpl fil up with Awakening gauge"),
    ("Explosive",  "Generates small explosinos while attacking"),
    ("Induction",   "Generates lightning bolts while attacking"),
    ("Vigor",      "Releases a protective shockwave when attacked"),
    ("Jolt",       "Raises attack power when equipping two weapons with the same affinity"),
    ("Protection", "Raises defense power when equipping two weapons with the same affinity"),
    ("Fear",       "Attacks may cause enemies to flee in terror"),
    ("Awe",        "Attacks may cause enemies to faint momentarily"),
    ("Morass",     "Attacks may inflict slow status on enemies"),
    ("Jubilation", "Restores a small portion of health by defeating enemies"),
    ("Roar",       "Restores a small portion of Musou by defeating enemies"),
    ("Triumph",    "Restores a small portion of the Awakening gauge by defeating enemies"),
    ("Gale",       "Raises attack power based on the number of enemies defeasted by the user"),
    ("Comet",      "Raises the distance enemies are flung by certain attacks"),
    ("Thunderclap", "The user will not flinch from attacks while running"),
    ("Efflorescence", "Raises duration of strength boost provided by switch counter"),
    ("Conflagration", "Causes eneimes sent flying to explode when colliding with others");