CREATE DATABASE IF NOT EXISTS awt_database;

USE awt_database;

-- Rooms table
CREATE TABLE IF NOT EXISTS rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    guest_capacity INT,
    size_sqm INT
);

-- Images table
CREATE TABLE IF NOT EXISTS images (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT,
    filename VARCHAR(255),
    description VARCHAR(255),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

-- Extras table
CREATE TABLE IF NOT EXISTS extras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

-- Room_has_extra table
CREATE TABLE IF NOT EXISTS room_has_extra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT,
    extra_id INT,
    FOREIGN KEY (room_id) REFERENCES rooms(id),
    FOREIGN KEY (extra_id) REFERENCES extras(id)
);

-- Guests table
CREATE TABLE IF NOT EXISTS guests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255) UNIQUE
);

-- Bookings table
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

-- Insert sample data into rooms table
INSERT INTO rooms (title, description, guest_capacity, size_sqm) VALUES
('Aurora Suite', 'Erleben Sie den Zauber des Nordlichts in dieser luxurioesen Suite mit spektakulaerer Aussicht.', 2, 50),
('Zen Garden Room', 'Ein friedlicher Rueckzugsort mit einer privaten Terrasse und Zugang zu einem japanischen Garten.', 3, 40),
('Skyline Loft', 'Modernes Design trifft auf beeindruckende Stadtansichten in diesem stilvollen Loft.', 4, 60),
('Safari Suite', 'Abenteuerliche Einrichtung und exotische Dekorationen bringen die Wildnis in diesen komfortablen Raum.', 2, 45),
('Underwater Escape', 'Tauchen Sie ein in die Welt unter dem Meer mit atemberaubenden Unterwasser-Dekorationen.', 2, 35),
('Royal Palace Room', 'Fuehlen Sie sich wie Koenige in diesem opulent gestalteten Raum mit eleganter Ausstattung.', 4, 55),
('Forest Retreat', 'Ein naturverbundener Raum, umgeben von gruenen Pflanzen und Holzdekor, ideal zum Entspannen.', 3, 40),
('Desert Oasis', 'Ein warmer, einladender Raum, inspiriert von den Farben und Formen der Wueste.', 2, 30),
('Mountain Peak Suite', 'Genießen Sie die Ruhe und Schoenheit der Berge in dieser geraeumigen Suite mit Panoramablick.', 4, 65),
('Galaxy Room', 'Schlafen Sie unter den Sternen in diesem futuristischen Raum mit kosmischer Dekoration.', 2, 35);

-- Insert sample data into guests table
INSERT INTO guests (firstname, lastname, email) VALUES
('John', 'Doe', 'john.doe@example.com'),
('Jane', 'Smith', 'jane.smith@example.com'),
('Alice', 'Johnson', 'alice.johnson@example.com'),
('Bob', 'Williams', 'bob.williams@example.com'),
('Charlie', 'Brown', 'charlie.brown@example.com');

-- Insert sample data into bookings table
INSERT INTO bookings (room_id, guest_id, start_date, end_date, breakfast) VALUES
(1, 1, '2024-07-01', '2024-07-05', 1),
(2, 2, '2024-07-10', '2024-07-15', 0),
(3, 3, '2024-07-20', '2024-07-25', 1),
(4, 4, '2024-07-05', '2024-07-10', 1),
(5, 5, '2024-07-15', '2024-07-20', 0);

-- Insert sample data into extras table
INSERT INTO extras (name, description) VALUES
('Balcony', 'A private balcony with a view'),
('Air Conditioning', 'In-room air conditioning'),
('Bathroom', 'Private bathroom'),
('Whirlpool', 'In-room whirlpool');

-- Insert sample data into room_has_extra table
INSERT INTO room_has_extra (room_id, extra_id) VALUES
(1, 1), -- Aurora Suite has Balcony
(1, 2), -- Aurora Suite has Air Conditioning
(2, 3), -- Zen Garden Room has Bathroom
(3, 4); -- Skyline Loft has Whirlpool

-- Insert sample data into images table
--INSERT INTO images (room_id, filename, description) VALUES
--(1, 'aurora_suite_1.jpg', 'Main view of Aurora Suite'),
--(2, 'zen_garden_room_1.jpg', 'Main view of Zen Garden Room'),
--(3, 'skyline_loft_1.jpg', 'Main view of Skyline Loft'),
--(4, 'safari_suite_1.jpg', 'Main view of Safari Suite'),
--(5, 'underwater_escape_1.jpg', 'Main view of Underwater Escape');