var app = angular.module("myApp",[]);
app.controller('appController',function($scope,$http){
	
	//Remplissage de tableau par les donnée de la page 0
	
		$http.get("/produits?page=0").success(function(data){
			$scope.produits=data.content;
			$scope.pages=new Array(data.totalPages);
			
			$scope.currentpage=data.number;
			$scope.description="";
			
		//Fonction de rechargement de contenu
		
		$scope.chercher=function(page){
			$http.get("/produitsByDesc?description="+$scope.description+"&page="+page).success(function(data){
				$scope.produits=data.content;
				$scope.pages=new Array(data.totalPages);
				$scope.currentpage=data.number;
				});
		}
				
	});
	
	
	})