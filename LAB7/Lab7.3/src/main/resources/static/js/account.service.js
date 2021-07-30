angular.module("myApp")
.factory("AccountService", function(Constant, $http) {

    var apiUrl = Constant.BASE_URL+'/accounts';
    var actions = {
        findAll: findAll
    }

    return actions;

    function findAll() {
        return $http.get(apiUrl).then(resp => resp.data)
    }

})