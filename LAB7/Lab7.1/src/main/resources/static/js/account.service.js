angular.module("myApp")
.factory("AccountService", function(Constant, $http) {

    var apiUrl = Constant.baseUrl+'/accounts';
    var actions = {
        findAll: findAll
    }

    return actions;

    function findAll() {
        return $http.get(apiUrl).then(resp => resp.data)
    }

})