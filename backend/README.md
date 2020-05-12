**CoffeeSpot**

Backend server for CoffeeSpot app

****

**Run Docker container**

`docker build -t backend-coffeespot . ` - Building docker image named ' backend-coffeeSpot'  
`docker run -p 8080:8080 -it  backend-coffeespot` - Run the docker container  

After first run you could start it by next command:  
`docker start backend-coffeespot`

**Run by jar file**   
Copy jar file from /build/libs to main directory    

Run in terminal `java -jar backend.jar`
****

**Main routes:**  

`/api/item` - GET - Getting all items as JSON  
`/api/item` - POST - Add new item as  
`/api/item` - DELETE - Remove item by ID
`/api/transaction` - GET - Getting all transaction   
`/api/transaction` - POST - Add new transaction
`/api/transaction` - DELETE - Remove transaction by ID   
`/storage/image/{img}` - GET - Getting image by name (The name you could get in item)  
`/storage/image` - POST - Adding new picture and return the uuid name of that pic   


**Description for routes**   
`/storage/image` :   
POST method   
multipart/form-data   
image: file - name and value of data

`/api/item`   
POST method   
application/json   
Ex:   
_{"name":"Croissant", "description": "Мягкий и вкусный круосан" ,"type":"FOOD", "price":12 ,"pic": "croissant.jpg" }_    

`/api/item`   
DELETE method    
**multipart/form-data**   
Ex:    
_id: 33_

`/api/transaction`   
GET method 

`/api/transaction`   
POST method   
application/json    
Ex:   
_{ "date": "2020-03-23", "items":[33,39],"count":"Use and parse it how'd you like", " "payment": 64}_   
items - It's massive of item(Product) ID      
count? - it's simple string for count items (Nullable)
payment - Int - All paid money for one transaction   

`/api/transaction`   
DELETE method    
**multipart/form-data**   
Ex:    
_id: 65_
****