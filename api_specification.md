# API Specification

We want to use a REST API and query parameters for Rooms and availability.
We further want to use a POST request for potential booking requests. 
Some additional static pages will be defined, may change in the future.

## Endpoint API
•	**Rooms** (list of rooms)  
>parameter /rooms?=page=x  
>Availability /rooms?page=x&=start=y&end=z 

•	**Rooms/ID** (specific Room)  
•	**Contact** (static page)  
•	**Information** (static page)  
•	**Booking**  
>/bookings/{id} for confirmation API  
>/bookings -> POST     


```json
{
“roomId” : "",
“startDate”: "",
“endDate”: "",
"firstname": "",
"lastname": "",
"email": "",
"breakfast": "yes/no",
}
```


  


