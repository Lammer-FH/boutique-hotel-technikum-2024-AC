CREATE DATABASE IF NOT EXISTS awt_database;

USE awt_database;

CREATE TABLE IF NOT EXISTS rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    guest_capacity INT,
    size_sqm INT
);

INSERT INTO rooms (title, description, guest_capacity, size_sqm) VALUES
('Aurora Suite', 'Erleben Sie den Zauber des Nordlichts in dieser luxurioesen Suite mit spektakulärer Aussicht.', 2, 50),
('Zen Garden Room', 'Ein friedlicher Rückzugsort mit einer privaten Terrasse und Zugang zu einem japanischen Garten.', 3, 40),
('Skyline Loft', 'Modernes Design trifft auf beeindruckende Stadtansichten in diesem stilvollen Loft.', 4, 60),
('Safari Suite', 'Abenteuerliche Einrichtung und exotische Dekorationen bringen die Wildnis in diesen komfortablen Raum.', 2, 45),
('Underwater Escape', 'Tauchen Sie ein in die Welt unter dem Meer mit atemberaubenden Unterwasser-Dekorationen.', 2, 35),
('Royal Palace Room', 'Fühlen Sie sich wie Könige in diesem opulent gestalteten Raum mit eleganter Ausstattung.', 4, 55),
('Forest Retreat', 'Ein naturverbundener Raum, umgeben von grünen Pflanzen und Holzdekor, ideal zum Entspannen.', 3, 40),
('Desert Oasis', 'Ein warmer, einladender Raum, inspiriert von den Farben und Formen der Wüste.', 2, 30),
('Mountain Peak Suite', 'Genießen Sie die Ruhe und Schönheit der Berge in dieser geräumigen Suite mit Panoramablick.', 4, 65),
('Galaxy Room', 'Schlafen Sie unter den Sternen in diesem futuristischen Raum mit kosmischer Dekoration.', 2, 35);

CREATE TABLE IF NOT EXISTS bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT,
    guest_id INT,
    start_date DATE,
    end_date DATE,
    breakfast TINYINT,
    FOREIGN KEY (room_id) REFERENCES rooms(id),
    FOREIGN KEY (guest_id) REFERENCES guests(id)
);

CREATE TABLE IF NOT EXISTS guests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255)
);