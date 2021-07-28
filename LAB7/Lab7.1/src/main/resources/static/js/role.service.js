angular.module('myApp')
.factory('RoleService', function ($http, Constant) {
    var url = Constant.baseUrl + '/roles'
    var actions = {
        findAll: findAll
    }

    return actions;

    function findAll() {
        return $http.get(url).then(resp => resp.data)
    }
})