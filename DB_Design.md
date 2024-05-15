# Database Design

## Tables

### rooms

| Column         | Type      | Additional Info |
|----------------|-----------|-----------------|
| id             | `int`     | auto increment  |
| title          | `varchar` |                 |
| description    | `varchar` |                 |
| guest_capacity | `int`     |                 |
| size_sqm       | `int`     |                 |

### images (1:n)

| Column      | Type      | Additional Info                                  |
|-------------|-----------|--------------------------------------------------|
| id          | `int`     | auto increment                                   |
| room_id     | `int`     | foreign key to `rooms.id`                        |
| filename    | `varchar` | name of the file in the `images/rooms` directory |
| description | `varchar` |                                                  |

### extras

Possible extras are balcony, air conditioning, bathroom, whirlpool, etc.

| Column      | Type      | Additional Info |
|-------------|-----------|-----------------|
| id          | `int`     | auto increment  |
| name        | `varchar` |                 |
| description | `varchar` |                 |

### room_has_extra (m:n)

| Column   | Type  | Additional Info            |
|----------|-------|----------------------------|
| room_id  | `int` | foreign key to `rooms.id`  |
| extra_id | `int` | foreign key to `extras.id` |

### bookings

| Column     | Type      | Additional Info            |
|------------|-----------|----------------------------|
| id         | `int`     | auto increment             |
| room_id    | `int`     | foreign key to `rooms.id`  |
| guest_id   | `int`     | foreign key to `guests.id` |
| start-date | `date`    |                            |
| end-date   | `date`    |                            |
| breakfast  | `tinyint` |                            |

### guests

| Column    | Type      | Additional Info   |
|-----------|-----------|-------------------|
| id        | `int`     | auto increment    |
| firstname | `varchar` |                   |
| lastname  | `varchar` |                   |
| email     | `varchar` | unique constraint |
