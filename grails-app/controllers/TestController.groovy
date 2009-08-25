class TestController {
	def sqlBuilderService
	
    def users = { 
		def query = sqlBuilderService.users {
			like "name", "M%"
		}
		render "query=${query.toSql()}; params=${query.parameters}"
	}

    def usersEachRow = { 
		def query = sqlBuilderService.users {
			like "name", "M%"
		}
		def s = ""
		sqlBuilderService.eachRow(query){
			s += "${it}\n"
		}
		render s
	}

	def usersByCity = {
		def query = sqlBuilderService.usersByCity {
			maxResults 100
			order "c", "desc"
		}
		render "query=${query.toSql()}; params=${query.parameters}"
	}
	
	def usersByCityEachRow = {
		def query = sqlBuilderService.usersByCity {
			maxResults 100
			order "c", "desc"
		}
		def s = ""
		sqlBuilderService.eachRow(query){
			s += "${it}\n"
		}
		render s
	}

	def usersPlusCity = {
		def query = sqlBuilderService.usersPlusCity {
			like 'city', 'C%'
		}
		def s = "query=${query.toSql()}; params=${query.parameters}\n"
		sqlBuilderService.eachRow(query){
			s += "${it}\n"
		}
		render s
	}
		
}
