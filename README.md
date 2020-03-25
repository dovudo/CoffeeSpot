**CoffeeSpot**

Backend server for CoffeeSpot app

****

**Run Docker container**

`docker build -t backend-coffeespot . ` - Building docker image named ' backend-coffeespot'  
`docker run -p 80:8080 -it  backend-coffeespot` - Run the docker container  

After first run you could starting it by next command:  
`docker start  backend-coffeespot`

**Run by jar file**   

`java -jar build/lib/backend.jar`
****

**Main routes:**  

`/api/items` - GET - Getting all items as JSON  
`/api/item` - POST - Add new item as  
`/api/transaction` - GET Getting all transaction   
`/api/transaction` - POST Add new transaction   
`/storage/image/{img}` - GET Getting image by name (The name you could get in item)  
`/storage/image` - POST Add new image and return the uuid name of that pic   


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

`/api/transaction`   
POST method   
application/json    
Ex:   
_{ "date": "2020-03-23", "items":[33,39], "payment": 64}_   
"items" - It's array of item(Product) ID      
payment - Int - All paid money for one transaction   

****