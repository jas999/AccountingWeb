angular.module("accounting").service('DocumentService', function($q, $http){
	var findAllDocuments = function(userId){
	    return $q(function(resolve, reject) {
	    	var documentsAPI = '/find/topTenDocuments?userId='+userId;
		      $http.get(documentsAPI).then(function(resp){
		        resolve(resp);
		      }, function(error){
		        console.log(error)
		      });
	    });
	  };
	
	  
	  var findAllDocumentsByUserId = function(){
		    return $q(function(resolve, reject) {
		    	var userData = JSON.parse(localStorage.getItem("loggedInUser"));
		    	var documentsAPI = '/find/allContentUserDocumentsForNullPdfAndCategoryIdSubCategoryId?userId='+userData.userId;
			      $http.get(documentsAPI).then(function(resp){
			        resolve(resp);
			      }, function(error){
			        console.log(error)
			      });
		    });
	  };
	  
	  var saveDocumentRatting = function(postData) {
		  return $q(function(resolve, reject) {
		    	var rattingApi = '/save/documentRating';
			      $http.post(rattingApi,postData).then(function(resp){
			        resolve(resp);
			      }, function(error){
			        console.log(error)
			      });
		    });
	  }
	  return {
		  findAllDocuments : findAllDocuments,
		  findAllDocumentsByUserId : findAllDocumentsByUserId,
		  saveDocumentRatting : saveDocumentRatting
	  }
});