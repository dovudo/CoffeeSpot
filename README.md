**CoffeeSpot**

Backend server for CoffeeSpot app

**Run Docker container**

`docker build -t backend-coffeespot . ` - Building docker image named ' backend-coffeespot'  
`docker run -p 80:8080 -it  backend-coffeespot` - Run the docker container  

After first run you could starting it by next command:  
`docker start  backend-coffeespot`

**Main routes:**  

`/api/items` - GET - Getting all items as JSON  
`/api/item` - POST - Add new item as  
`/storage/image/{img}` - GET Getting image by name (The name you could get in item)  
`/storage/image` - POST Add new image and return the uuid name of that pic