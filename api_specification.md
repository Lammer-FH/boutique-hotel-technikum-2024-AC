# API Specification

We want to use a REST API and query parameters for Rooms and availability.
We further want to use a POST request for potential booking requests. 

## Endpoint API
### Rooms  
```/rooms?page=1``` (Pagination)  
```/rooms?page=1&start=2024-05-07&end=2024-05-15``` (Availability)   
```/rooms/{id}``` (Specific Room)  

###	Bookings  
```/bookings/{id}``` (Booking Confirmation)  
```/bookings``` (POST, Create New Booking)     


```json
{
    "roomId" : 123456,
    "startDate": "2024-05-07",
    "endDate": "2024-05-15",
    "firstname": "Thomas",
    "lastname": "Mustermann",
    "email": "thomas.mustermann@gmail.com",
    "breakfast": true
}
```


  


