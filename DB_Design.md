# Database Design

## Tables

### rooms

| Column          | Type      | Additional Info |
|-----------------|-----------|-----------------|
| id              | `int`     | auto increment  |
| title           | `varchar` |                 |
| description     | `varchar` |                 |
| person-capacity | `int`     |                 |
| size-sqm        | `int`     |                 |

### images (1:n)

| Column      | Type      | Additional Info                                  |
|-------------|-----------|--------------------------------------------------|
| id          | `int`     | auto increment                                   |
| room-id     | `int`     | foreign key to `rooms.id`                        |
| filename    | `varchar` | name of the file in the `images/rooms` directory |
| description | `varchar` |                                                  |

### extras

Possible extras are balcony, air conditioning, bathroom, whirlpool, etc.

| Column      | Type      | Additional Info |
|-------------|-----------|-----------------|
| id          | `int`     | auto increment  |
| name        | `varchar` |                 |
| description | `varchar` |                 |

### room-has-extra (m:n)

| Column   | Type  | Additional Info            |
|----------|-------|----------------------------|
| room-id  | `int` | foreign key to `rooms.id`  |
| extra-id | `int` | foreign key to `extras.id` |

### bookings

| Column     | Type      | Additional Info           |
|------------|-----------|---------------------------|
| id         | `int`     | auto increment            |
| room-id    | `int`     | foreign key to `rooms.id` |
| start-date | `date`    |                           |
| end-date   | `date`    |                           |
| firstname  | `varchar` |                           |
| lastname   | `varchar` |                           |
| email      | `varchar` |                           |
| breakfast  | `tinyint` |                           |

