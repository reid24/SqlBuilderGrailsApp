class BootStrap {

     def init = { servletContext ->
     	def cities = [
     	              "Toronto", "New York", "Los Angeles", "Chicago"
     	]
     	cities.each { city ->
     		if(!new City(cityName:city).save()) println city.errors
     	}
     	def users = [
     	             new User(name:"Mike Myers", city: City.findByCityName("Toronto")),
     	             new User(name:"Donald Trump", city: City.findByCityName("New York")),
     	             new User(name:"Barack Obama", city: City.findByCityName("Chicago")),
     	             new User(name:"Tom Cruise", city:City.findByCityName("Los Angeles")),
     	             new User(name:"Sammy Sosa", city:City.findByCityName("Chicago"))
     	]
     	users.each { user ->
     		if(!user.save()) println user.errors
     	}
     	             
     }
     def destroy = {
     }
} 